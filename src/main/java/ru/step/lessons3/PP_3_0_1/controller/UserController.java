package ru.step.lessons3.PP_3_0_1.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.step.lessons3.PP_3_0_1.model.User;
import ru.step.lessons3.PP_3_0_1.service.UserService;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userList(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "/users";
    }

    @PostMapping("/search")
    public String searchUserId(@RequestParam Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/showUserId";
    }

    @GetMapping("/create")
    public String newUser(@ModelAttribute("user") User user) {
        return "/create";
    }

    @PostMapping("/create")
    public String createNewUser(@ModelAttribute("user") @Valid User user,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/create";
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user",userService.getUser(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @RequestParam("id") Long id) {
        if (bindingResult.hasErrors())
            return "/edit";
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
