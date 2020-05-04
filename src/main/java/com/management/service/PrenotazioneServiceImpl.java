package com.management.service;

import com.management.dao.PrenotazioneDao;
import com.management.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Prenotazione> getReservationByUserId(int id) {
        return prenotazioneDao.getReservationByUserId(id);
    }

    @Override
    public Prenotazione getReservationById(int id) {
        return prenotazioneDao.getReservationById(id);
    }

    @Override
    public List<Prenotazione> getPendingReservations() {
        return prenotazioneDao.getPendingReservations();
    }
}
