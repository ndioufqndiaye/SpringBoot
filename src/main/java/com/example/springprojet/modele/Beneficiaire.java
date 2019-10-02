package com.example.springprojet.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size( max = 50)
    private String nomben;

    @NotBlank
    @Size( max = 50)
    private String prenomben;

    private  int telephoneben;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="beneficiaire")
    @JsonIgnoreProperties("beneficiaire")
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getNomben() {
        return nomben;
    }

    public void setNomben(String nomben) {
        this.nomben = nomben;
    }

    public String getPrenomben() {
        return prenomben;
    }

    public void setPrenomben(String prenomben) {
        this.prenomben = prenomben;
    }

    public int getTelephoneben() {
        return telephoneben;
    }

    public void setTelephoneben(int telephoneben) {
        this.telephoneben = telephoneben;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
