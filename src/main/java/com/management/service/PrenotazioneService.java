package com.management.service;

import com.management.model.Prenotazione;
import java.util.List;

public interface PrenotazioneService {
    List<Prenotazione> getReservations();
    void newReservation(Prenotazione prenotazione);
    void deleteReservation(int id);
    void updateReservation(Prenotazione prenotazione);
    List<Prenotazione> getReservationByUserId(int id);
    Prenotazione getReservationById(int id);
}
