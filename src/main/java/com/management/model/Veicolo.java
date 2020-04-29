package com.management.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Veicolo", schema="rentcar")
public class Veicolo{


    @Column(name="Id", updatable = false,nullable=false)
    public int id;

    @NotNull
    @NotEmpty
    @Column(name="Targa")
    public String targa;

    @NotEmpty
    @Column(name = "Modello")
    public String modello;

    @NotEmpty
    @Column(name="CasaCostrutt")
    public String casaCostrutt;


    @NotEmpty
    @Pattern(regexp = "^(19[0-9][0-9]|20[01][0-9]|2020)$")
    @Column(name="AnnoImm")
    public String annoImm;

    @Column(name="Prenotabile")
    public boolean prenotabile;

//    @OneToMany(cascade={CascadeType.ALL})
//    @JoinColumn(name="idPrenotazione")
//    private List<Prenotazione> prenotazioni;
//    public List<Prenotazione> getPrenotazioni(){
//        return prenotazioni;
//    }
//    public void setPrenotazioni(List<Prenotazione> prenotazioni){
//        this.prenotazioni = prenotazioni;
//    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Veicolo(){}

    public Veicolo(String targa, String modello, String casaCostrutt, String annoImm) {
        this.targa = targa;
        this. modello = modello;
        this.casaCostrutt = casaCostrutt;
        this.annoImm = annoImm;
    }
    public Veicolo(String targa, String modello, String casaCostrutt, String annoImm, boolean prenotabile) {
        this.targa = targa;
        this. modello = modello;
        this.casaCostrutt = casaCostrutt;
        this.annoImm = annoImm;
        this.prenotabile = prenotabile;
    }



    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getCasaCostrutt() {
        return casaCostrutt;
    }
    public void setCasaCostrutt(String casa) {
        this.casaCostrutt = casa;
    }

    public String getAnnoImm() {
        return annoImm;
    }

    public void setAnnoImm(String annoImm) {
        this.annoImm = annoImm;
    }

    public void setPrenotabile(boolean prenotabile) { this.prenotabile = prenotabile; }
    public boolean getPrenotabile() { return prenotabile; }
}