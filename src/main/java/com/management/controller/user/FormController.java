package com.management.controller.user;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/form")
@Controller
public class FormController {

    @RequestMapping
    public String LoginPage(Model model, Authentication authentication) {
        authentication.getPrincipal();
        model.addAttribute("message", "Hello Spring MVC Framework Login");
        return "loginForm";
    }

}