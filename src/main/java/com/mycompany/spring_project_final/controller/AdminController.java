package com.mycompany.spring_project_final.controller;

import com.mycompany.spring_project_final.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/home")
    public String home(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserEntity) {
            UserEntity userEntity = (UserEntity) principal;
            model.addAttribute("email", userEntity.getEmail());
        }
        model.addAttribute("msg", "This is admin home page!");
        return "/admin/home";
    }
}
