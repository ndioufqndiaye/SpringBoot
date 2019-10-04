package com.example.springprojet.controller;


import com.example.springprojet.modele.*;
import com.example.springprojet.repository.CompteRepository;
import com.example.springprojet.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/depots")
public class DepotController {

    @Autowired
    private DepotRepository depotRepository;
    @Autowired
    private CompteRepository compteRepository;

    @PostMapping(value = "/depote", consumes = {MediaType.APPLICATION_JSON_VALUE})

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public ResponseEntity<String> add(@RequestBody FormPart form) throws Exception {


        Depot depot = new Depot();
            if (form.getMontant() < 75000) {
                return new ResponseEntity("entrer un montant supérieur à 75000",HttpStatus.OK);

            }



        depot.setMontant(form.getMontant());
        Date date = new Date();
        depot.setDatedepot(date);
        Compte compte = compteRepository.findCompteByNumcompte(form.getNumcompte()).orElseThrow(() -> new ApplicationContextException("Compte  not found."));
        depot.setCompte(compte);
        compte.setSolde(compte.getSolde() + form.getMontant());
        compteRepository.save(compte);
        depotRepository.save(depot);

        return new ResponseEntity("depot effectuer avec succés", HttpStatus.OK);

    }
    @GetMapping(value = "/listedepot")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<Depot> listedepot(){
        return depotRepository.findAll();
    }

}

