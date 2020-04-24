package com.management.service;

import com.management.dao.PrenotazioneDao;
import com.management.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class PrenotazioneServiceImpl implements PrenotazioneService{

    @Autowired
    PrenotazioneDao prenotazioneDao;
    @Override
    public List<Prenotazione> getReservations() {
        return prenotazioneDao.getAllReservations();
    }

    @Override
    public void newReservation(Prenotazione prenotazione) {
        prenotazioneDao.saveReservation(prenotazione);
    }

    @Override
    public void deleteReservation(int id) {
        prenotazioneDao.deleteReservation(id);
    }

    @Override
    public void updateReservation(Prenotazione prenotazione) {
        prenotazioneDao.updateReservation(prenotazione);
    }

    @Override
    public void getReservationByUserId(int id) {
        prenotazioneDao.getReservationByUserId(id);
    }

    @Override
    public void getReservationById(int id) {
        prenotazioneDao.getReservationById(id);
    }
}
