package com.tuanluc.controller;

import com.tuanluc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @RequestMapping(value ={"/", "/home"})
    public String showHomePage(@RequestParam(value = "mess", required = false) String mess, Model model) {
        model.addAttribute("mess", mess);
        model.addAttribute("title", "Home Page de dang nhap input user name \"luc\" to login");
        return "home";
    }

    @RequestMapping("/login")
    public String showLoginPage(@RequestParam(value = "mess", required = false) String mess, @ModelAttribute("user") User user, Model model) {
        model.addAttribute("mess", mess);
        model.addAttribute("title", "Login");
        return "login";
    }

    @RequestMapping(value = "/handle-login", method = RequestMethod.POST)
    public RedirectView handleLogin(@ModelAttribute("user") User user, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        if (user.getUserName().equals("luc")) {
            redirectAttributes.addAttribute("mess", "Login successful");
            return new RedirectView("home");
        }
        redirectAttributes.addAttribute("mess", "User name " + user.getUserName() + " is wrong");
        return new RedirectView("login");
    }


    @RequestMapping("/test1/{id}")
    public String test1(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "test1";
    }

    @RequestMapping("/test2/{id}/{name}")
    public String test2(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestParam("name") String name, @RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test3";
    }

}

