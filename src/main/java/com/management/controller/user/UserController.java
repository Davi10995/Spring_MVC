package com.management.controller.user;


import com.management.model.User;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/user/**")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/editForm")
    public String editForm(@RequestParam(value = "id") String id, Model model){

        User user = userService.getUserById(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "editUser";
    }
    @RequestMapping(value = "/user/edit")
    public String edit(@RequestParam(value = "cf") String cf, @RequestParam(value = "nome") String nome,
                       @RequestParam(value = "cognome") String cognome, @RequestParam(value = "password") String password,
                       @RequestParam(value = "data") String date, @RequestParam(value = "tipo") String tipo,
                       @RequestParam(value = "id") String id, Model model) throws ParseException {
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String encodedPassword = encoder.encode(password);
        User user = new User(cf, nome, cognome, encodedPassword, tipo, data);
        user.id = Integer.parseInt(id);
        userService.updateUser(user);
        return "success";
    }

    @RequestMapping(value = "/user/newUserForm")
    public String newUserForm( Model model) throws ParseException {
        return "newUser";
    }
    @RequestMapping(value = "/user/newUser")
    public String newUser(@RequestParam(value = "cf") String cf, @RequestParam(value = "nome") String nome,
                          @RequestParam(value = "cognome") String cognome, @RequestParam(value = "password") String password,
                          @RequestParam(value = "data") String date) throws ParseException {
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String encodedPassword = encoder.encode(password);
        String tipo ="Customer";
        User user = new User(cf, nome, cognome, encodedPassword, tipo, data);
        userService.newUser(user);
        return "/success";
    }

    @RequestMapping(value = "/user/deleteRequest")
    public String deleteRequest( @RequestParam(value = "id") String id, Model model) throws ParseException {
        model.addAttribute("user",userService.getUserById(Integer.parseInt(id)));
        return "deleteRequest";
    }

    @RequestMapping(value = "/user/deleteUser")
    public String deleteUser( @RequestParam(value = "id") String id, Model model) throws ParseException {
        userService.deleteUser(Integer.parseInt(id));
        return "success";
    }

}
