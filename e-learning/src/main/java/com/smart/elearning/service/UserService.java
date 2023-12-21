package com.smart.elearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smart.elearning.dao.AbonnementRepository;
import com.smart.elearning.dao.UserRepository;
import com.smart.elearning.dto.UserAbonnementsDTO;
import com.smart.elearning.entity.Abonnement;
import com.smart.elearning.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
       return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }



      public ResponseEntity<Object> getUserAbonnement(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();

            List<Abonnement> UserAbonnements = abonnementRepository.findByEtudiant(user);
            var UserAbonnementsDTO = new UserAbonnementsDTO(UserAbonnements.size(), UserAbonnements);

            return ResponseEntity.ok().body(UserAbonnementsDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
    }


}