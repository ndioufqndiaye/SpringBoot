package com.example.springprojet.modele;

import java.util.Date;

public class FormPart {

    //User
    private String name;
    private  String username;
    private String email;
    private String password;
    private String matricule;
    private  String nom;
    private String prenom;
    private String adresse;
    private int telephone;
    private  String status;
    private String image_Name;
    private int id_compte;
    private int id_partenaire;
    private int numecompte;

    public int getNumecompte() {
        return numecompte;
    }

    public void setNumecompte(int numecompte) {
        this.numecompte = numecompte;
    }


    public int getId_partenaire() {
        return id_partenaire;
    }

    public void setId_partenaire(int id_partenaire) {
        this.id_partenaire = id_partenaire;
    }



    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage_Name() {
        return image_Name;
    }

    public void setImage_Name(String image_Name) {
        this.image_Name = image_Name;
    }




//Compte

    private Date datecreation;
    private int solde;
    private int numcompte;

    public int getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(int numcompte) {
        this.numcompte = numcompte;
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

//Partenaire


    private String nomPartenaire;

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    private  String nin;
   /* private String mat;
    private String adr;
    private int tel;
    private String mail;
    private String statut;*/


    /*public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }*/



    public String getNomPartenaire() {
        return nomPartenaire;
    }

    public void setNomPartenaire(String nomPartenaire) {
        this.nomPartenaire = nomPartenaire;
    }

//Depot

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    //private Date date;
    private int montant;

}
