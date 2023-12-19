package com.smart.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.elearning.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}