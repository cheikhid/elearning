package com.smart.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.elearning.dao.AbonnementRepository;
import com.smart.elearning.entity.Abonnement;

@Service
public class AbonnementService {
    
    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    public Abonnement getAbonnementById(Long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }

}