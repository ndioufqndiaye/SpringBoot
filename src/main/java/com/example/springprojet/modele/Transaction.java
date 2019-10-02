package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "services")

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size( max = 50)
    private String agence;

    private  int montant;

    @NotBlank
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datetransaction;


    private int code;

    @NotBlank
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateretrait;

    @NotBlank
    @Size( max = 50)
    private String type;


    private int comenvoi;
    private  int comretrait;
    private  int comwari;
    private int cometat;
    private int cni;

    @JoinColumn(name = "user_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("users")
    private User user;

    @JoinColumn(name = "useretrait_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("users")
    private User useretrait;

    @JoinColumn(name = "expediteur_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("expeds")
    private Expediteur expediteur;

    @JoinColumn(name = "beneficiaire_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("benefics")
    private Beneficiaire beneficiaire;

    @JoinColumn(name = "tarif_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("tars")
    private Tarifs tarifs;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUseretrait() {
        return useretrait;
    }

    public void setUseretrait(User useretrait) {
        this.useretrait = useretrait;
    }

   public Expediteur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Expediteur expediteur) {
        this.expediteur = expediteur;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Tarifs getTarifs() {
        return tarifs;
    }

    public void setTarifs(Tarifs tarifs) {
        this.tarifs = tarifs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDatetransaction() {
        return datetransaction;
    }

    public void setDatetransaction(Date datetransaction) {
        this.datetransaction = datetransaction;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateretrait() {
        return dateretrait;
    }

    public void setDateretrait(Date dateretrait) {
        this.dateretrait = dateretrait;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComenvoi() {
        return comenvoi;
    }

    public void setComenvoi(int comenvoi) {
        this.comenvoi = comenvoi;
    }

    public int getComretrait() {
        return comretrait;
    }

    public void setComretrait(int comretrait) {
        this.comretrait = comretrait;
    }

    public int getComwari() {
        return comwari;
    }

    public void setComwari(int comwari) {
        this.comwari = comwari;
    }

    public int getCometat() {
        return cometat;
    }

    public void setCometat(int cometat) {
        this.cometat = cometat;
    }

    public int getCni() {
        return cni;
    }

    public void setCni(int cni) {
        this.cni = cni;
    }


}
