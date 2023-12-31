package com.smart.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.elearning.entity.Abonnement;
import com.smart.elearning.entity.AppUser;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
    public List<Abonnement> findByEtudiant(AppUser user);
}