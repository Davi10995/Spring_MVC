package com.management.service;

import com.management.dao.VeicoloDao;
import com.management.model.Veicolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeicoloServiceImpl implements VeicoloService{

    @Autowired
    VeicoloDao veicoloDao;

    @Override
    public List<Veicolo> getVeicoli() {
        return veicoloDao.getAllVeicoli();
    }

    @Override
    public Veicolo getVeicoloById(int id) {
        return veicoloDao.getVeicoloById(id);
    }

    @Override
    public Veicolo getVeicoloByTarga(String targa) {
        return veicoloDao.getVeicoloByTarga(targa);
    }

    @Override
    public void updateVeicolo(Veicolo veicolo) {
        veicoloDao.updateVehicle(veicolo);
    }

    @Override
    public void newVeicolo(Veicolo veicolo) {
        veicoloDao.saveVeicolo(veicolo);
    }

    @Override
    public void deleteVeicolo(int id) {
        veicoloDao.deleteVehicle(id);
    }
}
