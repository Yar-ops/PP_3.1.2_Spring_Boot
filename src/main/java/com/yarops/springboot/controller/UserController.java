package com.yarops.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.yarops.springboot.model.User;
import com.yarops.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUser(ModelMap users) {
        users.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/saveget")
    public String saveUserGet(@ModelAttribute("user") User user) {
        return "user";
    }

    @PostMapping("/savepost")
    public String saveUserPost(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/usereditorget/{id}")
    public String userEditorGet(Model user, @PathVariable("id") Long id) {
        user.addAttribute("user", userService.getUserById(id));
        return "edituser";
    }

    @PatchMapping("/{id}")
    public String userEditorPatch(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.userEditor(user, id);
        return "redirect:/";
    }
}