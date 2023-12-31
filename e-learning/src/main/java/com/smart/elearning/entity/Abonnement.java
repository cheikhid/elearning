package com.smart.elearning.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Abonnement {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long idAbonnement;
 
    
 

    @Column
    private LocalDate startDate;
    
    @Column
    private LocalDate endDate;


    @ManyToOne(optional = false)
    private AppUser etudiant;
    
    @ManyToOne(optional = false)
    private Cours cours;


}