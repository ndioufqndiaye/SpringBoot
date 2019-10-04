package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "depots")
 public  class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datecreation;
    private int solde;
    private int numcompte;

    public int getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(int numcompte) {
        this.numcompte = numcompte;
    }

    @JsonIgnore
    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List<User> uses;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List<Depot> depots;

    @JsonIgnore
    @JoinColumn(name = "partenaire_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("comptes")
    private Partenaire partenaire;

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }



    public List<User> getUses() {
        return uses;
    }

    public void setUses(List<User> uses) {
        this.uses = uses;
    }

    public Compte() {}

    public Compte(int solde, Date datecreation) {
        this.solde = solde;
       this.datecreation= datecreation;

    }







}