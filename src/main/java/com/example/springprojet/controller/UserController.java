package com.example.springprojet.controller;


import com.example.springprojet.modele.Compte;
import com.example.springprojet.modele.Formulaire;
import com.example.springprojet.modele.Partenaire;
import com.example.springprojet.modele.User;
import com.example.springprojet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @PostMapping(value = "/ajout", consumes = {MediaType.APPLICATION_JSON_VALUE})

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public User add(@RequestBody(required = false) Formulaire form){

       User user=new User();

       user.setName(form.getName());
       user.setUsername(form.getUsername());
       user.setPassword(encoder.encode(form.getPassword()));
       user.setEmail(form.getEmail());
       user.setMatricule(form.getMatricule());
       user.setNom(form.getNom());
       user.setPrenom(form.getPrenom());
       user.setAdresse(form.getAdresse());
       user.setTelephone(form.getTelephone());
       user.setStatus(form.getStatus());
       user.setImage_Name(form.getImage_Name());

        Compte c = new Compte();
        c.setId(form.getId_compte());
        user.setCompte(c);

        Partenaire p = new Partenaire();
        p.setId(form.getId_partenaire());
        user.setPartenaire(p);

        return userRepository.save(user);
    }
}

