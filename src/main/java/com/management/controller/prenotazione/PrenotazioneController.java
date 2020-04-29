package com.management.controller.prenotazione;

import com.management.model.Prenotazione;
import com.management.model.User;
import com.management.model.Veicolo;
import com.management.service.PrenotazioneService;
import com.management.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(value = "/prenotazione/**")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    VeicoloService veicoloService;

    //    PRENOTAZIONE CRUD ACTIONS   --------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/prenotazione/newForm")
    public String newReservationForm(@RequestParam(value = "id") String id, Model model){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.fk_veicolo = Integer.parseInt(id);
        model.addAttribute("veicolo", veicoloService.getVeicoloById(Integer.parseInt(id)));
        model.addAttribute("prenotazione", prenotazione);
        return "newReservationForm";
    }

    @RequestMapping(value = "/prenotazione/new")
    public String newReservation(@Valid @ModelAttribute("prenotazione") Prenotazione prenotazione, BindingResult result,
                                 @RequestParam(value = "id") String id, @RequestParam(value = "dataI") String dataInizio,
                                 @RequestParam(value = "dataF") String dataFine, Model model) throws ParseException {

        if(result.hasErrors()){
            return "newReservationForm";
        }
        if(dataInizio.isEmpty() || dataFine.isEmpty()){
            model.addAttribute("error", "Inserisci la data");
            model.addAttribute("veicolo", veicoloService.getVeicoloById(prenotazione.fk_veicolo));
            return "newReservationForm";
        }
        prenotazione.dataInizio = new SimpleDateFormat("yyyy-MM-dd").parse(dataInizio);
        prenotazione.dataFine = new SimpleDateFormat("yyyy-MM-dd").parse(dataFine);
        prenotazione.fk_user = Integer.parseInt(id);
        Veicolo veicolo = veicoloService.getVeicoloById(prenotazione.fk_veicolo);
        veicolo.prenotabile = false;
        veicoloService.updateVeicolo(veicolo);
        prenotazioneService.newReservation(prenotazione);
        return "success";
    }
}
