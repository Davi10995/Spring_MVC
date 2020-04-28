package com.management.controller.user;

import com.management.model.Prenotazione;
import com.management.model.User;
import com.management.service.PrenotazioneService;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/home")
@Controller
@Scope("session")
public class LoginValidator {
    @Autowired
    UserService userService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @RequestMapping()
    public String LoginPage(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User currentUser = userService.getUserByCF(userDetail.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", currentUser);
        if(currentUser.tipo.equals("SuperUser")) {
            List<User> users = userService.getUsers();
            model.addAttribute("users", users);
            return "homeAdmin";
        }
        else {
            List<Prenotazione> resList = prenotazioneService.getReservationByUserId(currentUser.id);
            model.addAttribute("prenotazioni", resList);
            return "homeCustomer";
        }

    }
}