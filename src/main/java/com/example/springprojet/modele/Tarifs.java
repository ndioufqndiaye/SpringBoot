package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tarifs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  int borne_inferieur;
    private int borne_superieur;
    private int valeur;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="tarifs")
    @JsonIgnoreProperties("tarifs")
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorne_inferieur() {
        return borne_inferieur;
    }

    public void setBorne_inferieur(int borne_inferieur) {
        this.borne_inferieur = borne_inferieur;
    }

    public int getBorne_superieur() {
        return borne_superieur;
    }

    public void setBorne_superieur(int borne_superieur) {
        this.borne_superieur = borne_superieur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }




}
