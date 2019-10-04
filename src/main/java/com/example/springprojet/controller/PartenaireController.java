package com.example.springprojet.controller;


import com.example.springprojet.modele.*;
import com.example.springprojet.repository.CompteRepository;
import com.example.springprojet.repository.PartenaireRepository;
import com.example.springprojet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompteRepository compteRepository;


    @Autowired
    private PartenaireRepository partenaireRepository;

    @Autowired
    PasswordEncoder encoder;
    @PostMapping(value = "/ajoutpart", consumes = {MediaType.APPLICATION_JSON_VALUE})

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public String add(@RequestBody(required = false) FormPart formPart){


        Partenaire partenaire=new Partenaire();
        partenaire.setNinea(formPart.getNin());
        partenaire.setEmail(formPart.getEmail());
        partenaire.setAdresse(formPart.getAdresse());
        partenaire.setNomPartenaire(formPart.getNomPartenaire());
        partenaire.setTelephone(formPart.getTelephone());
        partenaire.setStatus(formPart.getStatus());
        partenaire.setMatricule(formPart.getMatricule());
        partenaireRepository.save(partenaire);

        Compte compte=new Compte();
        Date date=new Date();
        compte.setDatecreation(date);
        compte.setNumcompte(formPart.getNumcompte());
        compte.setSolde(formPart.getSolde());
        compte.setPartenaire(partenaire);
       compteRepository.save(compte);

       User user=new User();

       user.setName(formPart.getName());
       user.setUsername(formPart.getUsername());
       user.setPassword(encoder.encode(formPart.getPassword()));
       user.setEmail(formPart.getEmail());
       user.setMatricule(formPart.getMatricule());
       user.setNom(formPart.getNom());
       user.setPrenom(formPart.getPrenom());
       user.setAdresse(formPart.getAdresse());
       user.setTelephone(formPart.getTelephone());
       user.setStatus(formPart.getStatus());
       user.setImage_Name(formPart.getImage_Name());
        user.setPartenaire(partenaire);
        user.setCompte(compte);
        userRepository.save(user);

        return "partenaire ajouter avec succés";
    }
    @GetMapping(value = "/listepart")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<Partenaire> listepart(){
        return partenaireRepository.findAll();
    }

}

