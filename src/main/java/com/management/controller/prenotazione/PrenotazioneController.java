package com.management.controller.prenotazione;

import com.management.model.Prenotazione;
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

import javax.validation.Valid;
import java.text.ParseException;

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
                                 @RequestParam(value = "id") String id, Model model) throws ParseException {
        if(result.hasErrors()){
            return "newReservationForm";
        }
        if(prenotazione.dataFine.compareTo(prenotazione.dataInizio) <= 0 ){
            model.addAttribute("error", "la data di fine prenotazione non può essere precedente alla data di inizio.");
            return "newReservationForm";
        }
        prenotazione.fk_user = Integer.parseInt(id);
        Veicolo veicolo = veicoloService.getVeicoloById(prenotazione.fk_veicolo);
        veicolo.prenotabile = false;
        prenotazione.approvata = false;
        veicoloService.updateVeicolo(veicolo);
        prenotazioneService.newReservation(prenotazione);
        return "success";
    }

    @RequestMapping(value = "/prenotazione/editForm")
    public String editForm(Model model, @RequestParam(value = "id") String id){
        Prenotazione prenotazione = prenotazioneService.getReservationById(Integer.parseInt(id));
        model.addAttribute("prenotazione", prenotazione);
        return "editReservationForm";
    }

    @RequestMapping(value = "/prenotazione/edit")
    public String editReservation(@Valid @ModelAttribute("prenotazione") Prenotazione prenotazione, BindingResult result,
                                  Model model) throws ParseException {
        if(result.hasErrors()){
            return "editReservationForm";
        }
        if(prenotazione.dataFine.compareTo(prenotazione.dataInizio) <= 0 ){
            model.addAttribute("error", "la data di fine prenotazione non può essere precedente alla data di inizio.");
            return "editReservationForm";
        }
        prenotazioneService.updateReservation(prenotazione);
        return "success";
    }

    @RequestMapping(value = "/prenotazione/deleteRequest")
    public String deleteRequest(Model model, @RequestParam(value = "id") String id){
        model.addAttribute("id", id);
        return "deleteResRequest";
    }

    @RequestMapping(value = "/prenotazione/delete")
    public String delete(Model model, @RequestParam(value = "id") String id){
        Veicolo veicolo = veicoloService.getVeicoloById(prenotazioneService.getReservationById(Integer.parseInt(id)).fk_veicolo);
        veicolo.prenotabile = true;
        prenotazioneService.deleteReservation(Integer.parseInt(id));
        veicoloService.updateVeicolo(veicolo);
        return "success";
    }




    //    PRENOTAZIONE APPROVAZIONE  --------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/prenotazione/reservations")
    public String newReservationForm(Model model){
        model.addAttribute("prenotazioni", prenotazioneService.getPendingReservations());
        return "pendingReservations";
    }

    @RequestMapping(value = "/prenotazione/approva")
    public String approvaPrenotazione(@RequestParam(value = "id") String id, Model model){
        Prenotazione prenotazione = prenotazioneService.getReservationById(Integer.parseInt(id));
        prenotazione.approvata = true;
        prenotazioneService.updateReservation(prenotazione);
        return "success";
    }
}
