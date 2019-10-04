package com.example.springprojet.repository;


import com.example.springprojet.modele.Depot;
import com.example.springprojet.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
    Optional<Depot> findByMontant(String montant);

   // Boolean existsByUsername(String username);
   // Boolean existsByEmail(String email);

   /* @Query("SELECT u FROM User u WHERE u.login IS NULL")
    public List<User> users();*/
}