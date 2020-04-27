package com.management.controller.user;

import com.management.model.User;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping(value = "/home")
@Controller
@Scope("session")
public class LoginValidator {
    @Autowired
    UserService userService;

    @RequestMapping()
    public String LoginPage(Model model, HttpServletRequest request, @RequestParam("username") String username,  @RequestParam("password") String password) {

//        if(userService.validate(username, password)) {
//            User currentUser = userService.getUserByCF(username);
//            HttpSession session = request.getSession();
//            session.setAttribute("name", currentUser.nome);
//            session.setAttribute("tipo", currentUser.tipo);
//            session.setAttribute("userId", currentUser.id);
            return "home";
//        }else
//            return "login";
    }
}