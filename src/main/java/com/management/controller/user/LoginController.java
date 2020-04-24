package com.management.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/login", method = RequestMethod.GET)
@Controller
public class LoginController {

    @RequestMapping
    public String LoginPage(Model model){
        model.addAttribute("message", "Hello Spring MVC Framework Login");
        return "login";
    }

}