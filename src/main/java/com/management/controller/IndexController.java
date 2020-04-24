package com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
