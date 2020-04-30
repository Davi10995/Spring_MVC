package com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "index")
    public String Welcome(Model model){
        model.addAttribute("intestazione", "Benvenuti nel sito Rental Car");

        return "index";
    }

    @RequestMapping
    public String Welcome2(Model model){
        model.addAttribute("intestazione", "Benvenuti nel sito Rental Car");

        return "index";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accesDenied(Principal user){

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;
    }

}
