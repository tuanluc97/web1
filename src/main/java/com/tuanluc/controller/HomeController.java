package com.tuanluc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("title","Home Page");
        return "home";
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("title","Login");
        return "login";
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


//    @RequestMapping("/login")
//    public String showLoginPage(Model model) {
//        model.addAttribute("a","Title");
//        return "login";
//    }
}

