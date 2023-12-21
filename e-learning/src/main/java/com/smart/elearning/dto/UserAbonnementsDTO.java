package com.smart.elearning.dto;

import java.util.List;

import com.smart.elearning.entity.Abonnement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAbonnementsDTO {
    
    private int totalAbonnement;
    private List<Abonnement> abonnement;
}