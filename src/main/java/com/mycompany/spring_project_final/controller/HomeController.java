package com.mycompany.spring_project_final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model,
            @RequestParam(value = "error", required = false) String error) {
        if (error != null && !error.isEmpty() && error.equals("loginFail")) {
            model.addAttribute("msg", "Email or password incorrect. Try again!");
        }
        return "login";
    }
}
