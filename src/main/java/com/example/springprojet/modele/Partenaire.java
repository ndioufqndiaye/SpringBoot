package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "uses")


public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size( max = 50)
    private String matricule;

    @NotBlank
    @Size( max = 50)
    private String nomPartenaire;

    @NotBlank
    @Size( max = 100)
    private String ninea;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @NotBlank
    @Size( max = 15)
    private String adresse;

    private int telephone;


    @NotBlank
    @Size( max = 10)
    private String status;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<User> uses;

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<Compte> comptes;








    public List<User> getUses() {
        return uses;
    }

    public void setUses(List<User> uses) {
        this.uses = uses;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNomPartenaire() {
        return nomPartenaire;
    }

    public void setNomPartenaire(String nomPartenaire) {
        this.nomPartenaire = nomPartenaire;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



    public Partenaire() {}

    public Partenaire(String matricule, String nomPartenaire, String ninea, String email, String adresse, int telephone, String status) {
        this.matricule = matricule;
        this.nomPartenaire = nomPartenaire;
        this.ninea = ninea;
        this.email= email;
        this.adresse= adresse;
        this.telephone= telephone;
        this.status=status;

    }


}