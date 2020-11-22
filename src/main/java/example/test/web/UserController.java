package example.test.web;

import example.test.model.Role;
import example.test.model.User;
import example.test.service.RoleService;
import example.test.service.SecurityService;
import example.test.service.UserService;
import example.test.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RoleService roleService;


    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("roleList", roleService.findAll());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,
                               @RequestParam(name="buttonCancel", required = false) String btnCancel,
                               BindingResult bindingResult) {
        if(btnCancel != null)
            return "redirect:/login";
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/course";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Неверный логин или пароль.\n");

        if (logout != null)
            model.addAttribute("message", "Вы успешно вышли из аккаунта..\n");

        return "login";
    }

}

