package example.test.web;

import example.test.model.Course;
import example.test.model.Thema;
import example.test.model.User;
import example.test.service.CourseService;
import example.test.service.ThemaService;
import example.test.service.CourseServiceImpl;
import example.test.service.UserService;
import example.test.validator.ThemaValidator;
import example.test.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller("/thema")
public class ThemaController {
    @Autowired
    private ThemaService themaService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ThemaValidator themaValidator;



    @GetMapping({"/{course}/thema"})
    public String showThema(@PathVariable("course") String course,
                            Model model) {
        Course addCourse = courseService.findByCourse(course);
        model.addAttribute("showCreate", userValidator.userInRoleAccept("teacher"));
        model.addAttribute("themaList", themaService.findByIdCourse(addCourse.getId()));
        model.addAttribute("idCourse", addCourse.getId());
        model.addAttribute("course", addCourse.getCourse());
        model.addAttribute("courseName", addCourse.getCourseName());
        return "thema";
    }

    @GetMapping("/{course}/add_thema")
    public String addThema(@PathVariable("course") String course,
                           Model model) {
        model.addAttribute("themaForm", new Thema());
        model.addAttribute("idCourse", courseService.findByCourse(course).getId());
        model.addAttribute("course", course);
        return "add_thema";
    }

    @PostMapping("/{course}/add_thema")
    public String saveThema(@PathVariable("course") String course,
                            @RequestParam(name="buttonCancel", required = false) String btnCancel,
                            @ModelAttribute("themaForm") Thema themaForm,
                            BindingResult bindingResult,
                            Model model) {
        if(btnCancel != null)
            return "redirect:/" + course + "/thema";

        themaValidator.validate(themaForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add_thema";
        }

        themaService.save(themaForm);

        return "redirect:/" + course + "/thema";


    }

    @PostMapping ({"/redirectToThema"})
    public String redirectToThema(@RequestParam("course") String course) {
        return "redirect:/" + course + "/thema";
    }


}

