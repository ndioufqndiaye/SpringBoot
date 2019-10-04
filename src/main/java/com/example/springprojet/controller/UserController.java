package com.example.springprojet.controller;


import com.example.springprojet.modele.*;
import com.example.springprojet.repository.CompteRepository;
import com.example.springprojet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<User> listeuser(){
        return userRepository.findAll();
    }


    @PostMapping(value = "/ajout", consumes = {MediaType.APPLICATION_JSON_VALUE})

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public String add(@RequestBody(required = false) Formulaire form){

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

        return "utilisateur ajouter avec succés";
    }

    @PostMapping(value = "/compete", consumes = {MediaType.APPLICATION_JSON_VALUE})

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public String add(@RequestBody(required = false) FormPart forme) {
        Compte compte=new Compte();

        compte.setSolde(forme.getSolde());
        compte.setNumcompte(forme.getNumcompte());
        Partenaire p = new Partenaire();
        p.setId(forme.getId_partenaire());
        compte.setPartenaire(p);
        Date date=new Date();
        compte.setDatecreation(date);

        return "compte creer avec succés";
    }

    @GetMapping(value = "/listecomp")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<Compte> listecompte(){
        return compteRepository.findAll();
    }


   @PutMapping(value = "/bloquer/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String bloquer(@PathVariable("id") Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("user not found."));

        if (user.getStatus().equals("activer")){
            user.setStatus("bloquer");
          userRepository.save(user);
          return "vous etes bloquer";

        }else  if (user.getStatus().equals("bloquer")){
            user.setStatus("activer");
            userRepository.save(user);
            return "vous etes activer";
        }
        return "ok";
    }


}

