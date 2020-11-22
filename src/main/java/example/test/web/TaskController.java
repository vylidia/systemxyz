package example.test.web;

import example.test.model.Course;
import example.test.model.Statistic;
import example.test.model.Thema;
import example.test.model.Task;
import example.test.service.*;
import example.test.validator.TaskValidator;
import example.test.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller("/task")
public class TaskController {
    @Autowired
    private ThemaService themaService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TaskValidator taskValidator;

    @GetMapping({"/{course}/{thema}/task"})
    public String showTask(@PathVariable("course") String course,
                           @PathVariable("thema") String thema,
                           Model model) {
        Thema themaForTask = themaService.findByThema(thema);
        Course courseForThema = courseService.findByCourse(course);
        model.addAttribute("showCreate", userValidator.userInRoleAccept("teacher"));
        model.addAttribute("taskList", taskService.findByIdThema(themaForTask.getId()));
        model.addAttribute("idCourse", courseForThema.getId());
        model.addAttribute("course", courseForThema.getCourse());
        model.addAttribute("thema", themaForTask.getThema());
        model.addAttribute("themaName", themaForTask.getThemaName());
        model.addAttribute("idThema", themaForTask.getId());
        return "task";
    }

    @GetMapping("/{course}/{thema}/add_task")
    public String addTask(@PathVariable("course") String course,
                           @PathVariable("thema") String thema,
                           Model model) {
        model.addAttribute("taskForm", new Task());
        model.addAttribute("idThema", themaService.findByThema(thema).getId());
        model.addAttribute("thema", thema);
        model.addAttribute("course", course);
        return "add_task";
    }

    @PostMapping("/{course}/{thema}/add_task")
    public String saveTask(@PathVariable("course") String course,
                            @PathVariable("thema") String thema,
                            @ModelAttribute("taskForm") Task taskForm,
                            @RequestParam(name="buttonCancel", required = false) String btnCancel,
                            BindingResult bindingResult) {
        if(btnCancel != null)
            return "redirect:/" + course + "/" + thema + "/task";

        taskValidator.validate(taskForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/" + course + "/" + thema + "/add_task";
        }

        taskService.save(taskForm);
        System.out.println("test_task");

        return "redirect:/" + course + "/" + thema + "/task";


    }

    @GetMapping({"/{course}/{thema}/show_task/{taskId}"})
    public String showOneTask(@PathVariable ("course") String course,
                              @PathVariable ("thema") String thema,
                              @PathVariable ("taskId") String taskId,
                              @RequestParam (name = "ansUser", required = false) String ansUser,
                              Model model) {
        Optional<Task> taskShow = taskService.findById(Long.parseLong(taskId));
        if(taskShow.isPresent()) {
            if (ansUser != null) {
                if (ansUser.equals(taskShow.get().getAnswer()))
                    model.addAttribute("message", "Correct answer");
                else model.addAttribute("message", "Uncorrect answer");
                model.addAttribute("answer", ansUser);
            } else model.addAttribute("message", "Insert answer");
            model.addAttribute("taskId", taskShow.get().getId());
            model.addAttribute("taskName", taskShow.get().getTaskName());
            model.addAttribute("taskText", taskShow.get().getTaskText());
        }
        model.addAttribute("idThema", themaService.findByThema(thema).getId());
        model.addAttribute("thema", thema);
        model.addAttribute("course", course);
        return  "show_task";
    }

    @PostMapping ({"/redirectToTask"})
    public String redirectToThema(@RequestParam("course") String course,
                                  @RequestParam("thema") String thema) {
        return "redirect:/" + course + "/" + thema + "/task";
    }


    @PostMapping ({"/redirectToCurrentTask"})
    public String redirectToTask(@RequestParam("course") String course,
                                 @RequestParam("thema") String thema,
                                 @RequestParam("taskId") Long taskId,
                                 @RequestParam(name="ansUser", required = false) String ansUser) {
        Optional<Task> task = taskService.findById(taskId);
        if(ansUser != null) {
            System.out.println("ansUser =" + ansUser);
            return "redirect:/" + course + "/" + thema + "/show_task/" + task.get().getId() + "?ansUser=" + ansUser;
        }
        return "redirect:/" + course + "/" + thema + "/show_task/" + task.get().getId();
    }

    @PostMapping ({"/redirectNextTask"})
    public String redirectNextTask(@RequestParam("course") String course,
                                   @RequestParam("thema") String thema,
                                   @RequestParam("taskName") Integer taskName) {
        Task task = taskService.findByTaskNameAndIdThema(taskName + 1, themaService.findByThema(thema).getId());
        if(task == null)
            return "redirect:/" + course + "/" + thema + "/task";
        return "redirect:/" + course + "/" + thema + "/show_task/" + task.getId();
    }

    @PostMapping ({"/redirectPreviousTask"})
    public String redirectPreviousTask(@RequestParam("course") String course,
                                   @RequestParam("thema") String thema,
                                   @RequestParam("taskName") Integer taskName) {
        Task task = taskService.findByTaskNameAndIdThema(taskName - 1, themaService.findByThema(thema).getId());
        if(task == null)
            return "redirect:/" + course + "/" + thema + "/task";
        return "redirect:/" + course + "/" + thema + "/show_task/" + task.getId();
    }

    @PostMapping({"/redirectAllTask"})
    public String redirectAllTask(@RequestParam("course") String course,
                                  @RequestParam("thema") String thema,
                                  @RequestParam("taskName") String taskName,
                                  @RequestParam("ansUser") String ansUser) {
        return "redirect:/" + course + "/" + thema + "/allTasks" + "?taskName=[" + taskName + "]&ansUser=[" + ansUser + "]";
    }

    @GetMapping({"/{course}/{thema}/allTasks"})
    public String showAllTasks(@PathVariable ("course") String course,
                               @PathVariable ("thema") String thema,
                               HttpServletRequest request,
                               Model model) {
        List<Task> allTasks = taskService.findByIdThema(themaService.findByThema(thema).getId());
        String[] taskIds = request.getParameterValues("taskId");
        String[] ansUsers = request.getParameterValues("ansUser");
        String[] messages = new String[allTasks.size()];
        int res = 0;
        if(taskIds != null) {
            for (int i = 0; i < taskIds.length; i++) {
                System.out.println(taskIds[i]);
                Optional<Task> taskCheck = taskService.findById(Long.parseLong(taskIds[i]));
                if (ansUsers[i] != null) {
                    if (ansUsers[i].equals(taskCheck.get().getAnswer())) {
                        messages[i] = "Правильный ответ";
                        res++;
                    }
                    else {
                        messages[i] = "Неправильный ответ";
                    }
                } else messages[i] = "Введите ответ";
            }
            model.addAttribute("messageResult", "Всего:" + String.valueOf(res));
            if(!userValidator.userInRoleAccept("teacher")) {
                Statistic stat = new Statistic();
                stat.fill(courseService.findByCourse(course).getId(),
                        courseService.findByCourse(course).getCourseName(),
                        themaService.findByThema(thema).getId(),
                        themaService.findByThema(thema).getThemaName(),
                        request.getUserPrincipal().getName(),
                        new Date(),
                        res);
                statisticService.save(stat);
            }
        }
        else
            Arrays.fill(messages, "Insert answer");

        model.addAttribute("messageList", messages);
        model.addAttribute("listTask", allTasks);
        model.addAttribute("answer", ansUsers);
        model.addAttribute("thema", themaService.findByThema(thema));
        model.addAttribute("course", course);
        return  "show_all_tasks";
    }




}

