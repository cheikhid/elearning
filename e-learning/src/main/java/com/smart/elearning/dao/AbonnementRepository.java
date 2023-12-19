package com.smart.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.elearning.entity.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}