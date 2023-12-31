package com.smart.elearning.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.elearning.utils.Constants;

import com.smart.elearning.entity.Abonnement;
import com.smart.elearning.service.AbonnementService;


@RestController
@RequestMapping(Constants.APP_ROOT+Constants.ABONNEMENT)
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;


    // Endpoints pour l'entité Abonnement

    @PostMapping
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.saveAbonnement(abonnement);
    }
    
    @GetMapping
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/{id}")
    public Abonnement getAbonnementById(@PathVariable Long id) {
        return abonnementService.getAbonnementById(id);
    }

   

    @DeleteMapping("/{id}")
    public void deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
    }




}