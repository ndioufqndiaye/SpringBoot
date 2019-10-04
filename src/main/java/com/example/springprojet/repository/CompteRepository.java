package com.example.springprojet.repository;


import com.example.springprojet.modele.Compte;
import com.example.springprojet.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findByNumcompte(String numcompte);
    Boolean existsByNumcompte(String numcompte);



    Optional<Compte> findCompteByNumcompte(int numcompte);
    //Boolean existsByEmail(String email);

   /* @Query("SELECT u FROM User u WHERE u.login IS NULL")
    public List<User> users();*/
}