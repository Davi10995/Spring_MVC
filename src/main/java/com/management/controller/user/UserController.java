package com.management.controller.user;


import com.management.model.Prenotazione;
import com.management.model.User;
import com.management.service.PrenotazioneService;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user/**")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PrenotazioneService prenotazioneService;

    //    USER CRUD ACTIONS   --------------------------------------------------------------------------------------------------
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
        return "success";
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


    //------------------------------------------------------------------------------------------------------------------------


    //    SHPOW USER PROFILE ------------------------------------------------------
    @RequestMapping(value = "/user/userProfile")
    public String profilo(Model model) throws ParseException {
        return "userProfile";
    }


    //    SHOW USER RESERVATIONS ------------------------------------------------------
    @RequestMapping(value = "/user/userReservations")
    public String prenotazioni(Model model, @RequestParam(value = "id") String id) throws ParseException {
        List<Prenotazione> resList = prenotazioneService.getReservationByUserId(Integer.parseInt(id));
        model.addAttribute("prenotazioni", resList);
        return "userReservation";
    }


    //    EDIT USER CREDENTIALS ------------------------------------------------------
    @RequestMapping(value = "/user/editCredentialsForm")
    public String editCredentialsForm(Model model) throws ParseException {
        return "editCredentials";
    }

    @RequestMapping(value = "/user/editCredentials")
    public String editCredentials(@RequestParam(value = "cf") String cf, @RequestParam(value = "nome") String nome,
                       @RequestParam(value = "cognome") String cognome, @RequestParam(value = "password") String oldPassword,
                       @RequestParam(value = "data") String date, @RequestParam(value = "tipo") String tipo,
                       @RequestParam(value = "id") String id, Model model) throws ParseException {
        if(date.equals("")){
            model.addAttribute("error", "Inserire la data");
            return "editCredentials";
        }
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        User user = new User(cf, nome, cognome, oldPassword, tipo, data);
        user.id = Integer.parseInt(id);
        userService.updateUser(user);
        return "success";
    }



//    EDIT USER PASSWORD ------------------------------------------------------
    @RequestMapping(value = "/user/editPasswordForm")
    public String editPasswordForm(Model model) throws ParseException {
        return "editPassword";
    }

    @RequestMapping(value = "/user/editPassword")
    public String modificaPassword(@RequestParam(value = "newPassword") String newPassword, @RequestParam(value = "oldPassword") String oldPassword,
                                   Model model, Authentication authentication) throws ParseException {
        if(oldPassword.equals("") || newPassword.equals("")){
            model.addAttribute("error", "Inserire entrambe le password");
            return "editPassword";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        User u = userService.getUserByCF(authentication.getName());
        if(!encoder.matches(oldPassword, u.password)){
            model.addAttribute("error", "Vecchia password errata");
            return "editPassword";
        }
        String password = encoder.encode(newPassword);
        User user = new User(u.cf, u.nome, u.cognome, password , u.tipo, u.data);
        user.id = u.id;
        userService.updateUser(user);
        return "success";
    }


}
