package com.example.springprojet.repository;


import com.example.springprojet.modele.Partenaire;
import com.example.springprojet.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    Optional<Partenaire> findByMatricule(String matricule);
    Boolean existsByMatricule(String matricule);
   // Boolean existsByEmail(String email);

   /* @Query("SELECT u FROM User u WHERE u.login IS NULL")
    public List<User> users();*/
}