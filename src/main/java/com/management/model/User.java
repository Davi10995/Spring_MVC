package com.management.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="User")
public class User {


    @Column(name="Id", updatable = false,nullable=false)
    public int id;

    @NotNull
    @NotEmpty
    @Column(name="CF")
    public String cf;

    @NotEmpty
    @Column(name="Nome")
    public String nome;

    @NotEmpty
    @Column(name="Cognome")
    public String cognome;

    @NotEmpty
    @NotNull
    @Column(name="Password")
    public String password;

    @Column(name="Tipo")
    public String tipo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="Data")
    public Date data;

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
    public void setId(int id){
        this.id=id;
    }
    public User() {
    }

    public User(String cf, String name, String cognome, String password, String tipo, Date data) {
        this.cf = cf;
        this.nome = name;
        this.cognome = cognome;
        this.password = password;
        this.tipo = tipo;
        this.data = data;
    }
    public User(String name, String cognome, String tipo, Date data) {
        this.nome = name;
        this.cognome = cognome;
        this.tipo = tipo;
        this.data = data;
    }
    public User(String name, String cognome, String password, String tipo, Date data) {
        this.nome = name;
        this.cognome = cognome;
        this.password = password;
        this.tipo = tipo;
        this.data = data;
    }


    public String getCf() {
        return cf;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String name) {
        this.nome = name;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public boolean match(String name, String password) {
        return this.nome.equals(name) && this.password.equals(password);
    }
}