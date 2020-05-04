package com.management.controller.user;


import com.management.model.Prenotazione;
import com.management.model.User;
import com.management.service.PrenotazioneService;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
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

    @RequestMapping(value = "user/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) throws ParseException {
        if(result.hasErrors()){
            return "editUser";
        }
        if(user.data==null){
            model.addAttribute("error", "Inserisci la data");
            return "editUser";
        }
        userService.updateUser(user);
        return "success";
    }

    @
    RequestMapping(value = "/user/newUserForm")
    public String newUserForm( Model model) throws ParseException {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }
    @RequestMapping(value = "/user/newUser", method = RequestMethod.POST)
    public String newUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) throws ParseException {

        if(result.hasErrors()){
            return "newUser";
        }
        if(user.data==null){
            model.addAttribute("error", "Inserisci la data");
            return "newUser";
        }
        user.tipo = "Customer";
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


    //    SHOW USER PROFILE ------------------------------------------------------
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
    public String editCredentialsForm(Model model, @RequestParam(value = "id") String id) throws ParseException {
        User user = userService.getUserById(Integer.parseInt(id));
//        user.data = null;
        model.addAttribute("user", user);
        return "editCredentials";
    }

    @RequestMapping(value = "user/editCredentials")
    public String editCredentials(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) throws ParseException {
        if(result.hasErrors()){
            return "editCredentials";
        }
        if(user.data==null){
            model.addAttribute("error", "Inserisci la data");
            return "newUser";
        }
        userService.updateUser(user);
        return "success";
    }




//    EDIT USER PASSWORD ------------------------------------------------------
    @RequestMapping(value = "/user/editPasswordForm")
    public String editPasswordForm(Model model, @RequestParam(value = "id") String id) throws ParseException {
        model.addAttribute("user", userService.getUserById(Integer.parseInt(id)));
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
