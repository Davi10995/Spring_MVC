package com.management.controller.veicolo;

import com.management.model.User;
import com.management.model.Veicolo;
import com.management.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/veicolo/**")
public class VeicoloController {

    @Autowired
    VeicoloService veicoloService;

    //    VEICOLO CRUD ACTIONS   --------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/veicolo/editVehicleForm")
    public String editForm(@RequestParam(value = "id") String id, Model model){

        Veicolo veicolo = veicoloService.getVeicoloById(Integer.parseInt(id));
        model.addAttribute("veicolo", veicolo);
        return "editVehicleForm";
    }

    @RequestMapping(value = "/veicolo/newVehicleForm")
    public String newVehicleForm(Model model){
        model.addAttribute("veicolo", new Veicolo());
        return "newVehicleForm";
    }

//    @RequestMapping(value = "/veicolo/newVehicle")
//    public String newVeichle(@RequestParam(value = "targa") String targa, @RequestParam(value = "anno") String anno,
//                             @RequestParam(value = "casa") String casa, @RequestParam(value = "modello") String modello,
//                             Model model){
//
//        Veicolo veicolo = new Veicolo(targa, modello, casa, anno, true);
//        veicoloService.newVeicolo(veicolo);
//        return "success";
//    }
    @RequestMapping(value = "/veicolo/newVehicle")
    public String newVeichle(@Valid
                          @ModelAttribute("veicolo") Veicolo veicolo, BindingResult result) throws ParseException {

        if(result.hasErrors()){
            return "newVehicleForm";
        }
        veicolo.prenotabile=true;
        veicoloService.newVeicolo(veicolo);
        return "success";
    }

    @RequestMapping(value = "/veicolo/editVehicle")
    public String editVehicle(@Valid
                                  @ModelAttribute("veicolo") Veicolo veicolo, BindingResult result, @RequestParam(value = "id") String id,
                                  @RequestParam(value = "prenotabile") String prenotabile) throws ParseException {

        if(result.hasErrors()){
            return "editVehicleForm";
        }
        veicolo.id = Integer.parseInt(id);
        veicolo.prenotabile = Boolean.parseBoolean(prenotabile);
        veicoloService.updateVeicolo(veicolo);
        return "success";
    }

    @RequestMapping(value = "/veicolo/delete")
    public String deleteVehicle(@RequestParam(value = "id") String id, Model model){

        Veicolo veicolo = veicoloService.getVeicoloById(Integer.parseInt(id));
        if(veicolo.prenotabile) {
            veicoloService.deleteVeicolo(Integer.parseInt(id));
            return "success";
        }else{
            model.addAttribute("listVeicoli", veicoloService.getVeicoli());
            model.addAttribute("errorDelete", "Veicolo prenotato");
            return "parcoAuto";
        }
    }


    //    SHOW PARCO AUTO ------------------------------------------------------
    @RequestMapping(value = "/veicolo/parcoAuto")
    public String parcoAuto(Model model) throws ParseException {
        List<Veicolo> veicoli = veicoloService.getVeicoli();
        model.addAttribute("listVeicoli", veicoli);
        return "parcoAuto";
    }
}
