package com.smart.elearning.entity;


import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cours {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long id; 
    
    @Column
    private String titre;

    @Column
    private String description;
    
    @OneToMany(mappedBy = "cours")
    private List<Abonnement> abonnements;

}