package com.management.service;

import com.management.model.Prenotazione;
import java.util.List;

public interface PrenotazioneService {
    List<Prenotazione> getReservations();
    void newReservation(Prenotazione prenotazione);
    void deleteReservation(int id);
    void updateReservation(Prenotazione prenotazione);
    void getReservationByUserId(int id);
    void getReservationById(int id);
}
