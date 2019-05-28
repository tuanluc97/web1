package com.tuanluc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tuanluc.entities.User;
import com.tuanluc.service.UserService;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value={"/user", "/user-list"})
    public String listUser(Model model) {
        model.addAttribute("listUser", userService.findAll());
        return "user-list";
    }
    @RequestMapping("/user-save")
    public String insertUser(Model model) {
        model.addAttribute("user", new User());
        return "user-save";
    }
    @RequestMapping("/user-view/{id}")
    public String viewUser(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-view";
    }

    @RequestMapping("/user-update/{id}")
    public String updateUser(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @RequestMapping("/saveUser")
    public String doSaveUser(@ModelAttribute("User") User user, Model model) {
        userService.save(user);
        model.addAttribute("listUser", userService.findAll());
        return "user-list";
    }
    @RequestMapping("/updateUser")
    public String doUpdateUser(@ModelAttribute("User") User user, Model model) {
        userService.update(user);
        model.addAttribute("listUser", userService.findAll());
        return "user-list";
    }

    @RequestMapping("/userDelete/{id}")
    public String doDeleteUser(@PathVariable int id, Model model) {
        userService.delete(id);
        model.addAttribute("listUser", userService.findAll());
        return "user-list";
    }
}
