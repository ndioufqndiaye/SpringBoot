package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@EqualsAndHashCode(exclude = "service")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size( max = 50)
    private String name;

    @NotBlank
    @Size( max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size( max = 100)
    private String password;

    @NotBlank
    @Size( max = 15)
    private String matricule;

    @NotBlank
    @Size( max = 100)
    private String nom;

    @NotBlank
    @Size( max = 100)
    private String prenom;

    @NotBlank
    @Size( max = 10)
    private String adresse;


    private int telephone;


    @NotBlank
    @Size( max = 10)
    private String status;

    @NotBlank
    @Size( max = 10)
    private String image_Name;


    @JsonIgnore
    @JoinColumn(name = "compte_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("uses")
    private Compte compte;


     @JsonIgnore
    @JoinColumn(name = "partenaire_id",referencedColumnName ="id")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JsonIgnoreProperties("uses")
    private Partenaire partenaire;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="user")
    @JsonIgnoreProperties("user")
    private List<Transaction> transactions;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String name, String username, String email, String password, String matricule, String nom, String prenom, String adresse, int telephone, String status, String image_Name) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.matricule= matricule;
        this.nom= nom;
        this.prenom= prenom;
        this.adresse= adresse;
        this.telephone= telephone;
        this.status=status;
        this.image_Name= image_Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}