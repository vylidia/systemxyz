package example.test.web;

import example.test.model.Course;
import example.test.model.User;
import example.test.service.CourseService;
import example.test.service.CourseServiceImpl;
import example.test.service.UserService;
import example.test.validator.CourseValidator;
import example.test.validator.UserValidator;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseValidator courseValidator;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/add_course")
    public String newCourse(Model model,
                            HttpServletRequest request) {
        model.addAttribute("courseForm", new Course());
        model.addAttribute("idUser", userService.findByUsername(request.getUserPrincipal().getName()).getId());
        return "add_course";
    }

    @PostMapping("/add_course")
    public String addCourse(@ModelAttribute("courseForm") Course courseForm,
                         @RequestParam(name="buttonCancel", required = false) String btnCancel,
                         BindingResult bindingResult) {
        if(btnCancel != null)
            return "redirect:/course";

        courseValidator.validate(courseForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add_course";
        }
        courseService.save(courseForm);
        return "redirect:/course";
    }

    @GetMapping({"/", "/course"})
    public String showCourse(Model model) {
        model.addAttribute("showCreate", userValidator.userInRoleAccept("teacher"));
        model.addAttribute("courseList", courseService.findAll());
        System.out.println("test");
        return "course";
    }

}

