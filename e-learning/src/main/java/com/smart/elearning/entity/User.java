package com.smart.elearning.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.elearning.enumeration.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Userapp")
public class User {
        @Id
        @GeneratedValue(strategy =GenerationType.AUTO )
        private Long id; 

        @Column(nullable = false)
        private String prenom;

        @Column(nullable = false)
        private String nom; 

        @Column(nullable = true)
        private int age; 

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String motDePasse;

        @Column(nullable = false)
        private Role role;
        
        @JsonIgnore
        @OneToMany(mappedBy = "etudiant")
        private List<Abonnement> abonnements;
}