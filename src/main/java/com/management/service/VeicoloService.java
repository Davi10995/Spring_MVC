package com.management.service;

import com.management.model.Veicolo;

import java.util.List;

public interface VeicoloService {

    List<Veicolo> getVeicoli();
    Veicolo getVeicoloById(int id);
    Veicolo getVeicoloByTarga(String targa);
    void updateVeicolo(Veicolo veicolo);
    void newVeicolo(Veicolo veicolo);
    void deleteVeicolo(int id);
}
