package com.smart.elearning.entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.elearning.enumeration.Rrole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Userapp")
public class AppUser {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(nullable = false, unique = true)
        private String username;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false, updatable = true)
        private String password;
        @Column(unique = true)
        private String nni;
        @Column(unique = true)
        private String phoneNumber;
        private String address;

        


        @ManyToOne(optional = true)
        private Role role;
        
        @JsonIgnore
        @OneToMany(mappedBy = "etudiant")
        private List<Abonnement> abonnements;



        @CreationTimestamp
        private LocalDateTime createdAt;

        @LastModifiedDate
        private LocalDateTime updatedAt;
}