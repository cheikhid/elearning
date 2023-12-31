package com.smart.elearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.elearning.dao.AbonnementRepository;
import com.smart.elearning.dao.RoleRepository;
import com.smart.elearning.dao.UserRepository;
import com.smart.elearning.dto.UserAbonnementsDTO;
import com.smart.elearning.entity.Abonnement;
import com.smart.elearning.entity.AppUser;
import com.smart.elearning.entity.Role;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }

    public AppUser getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public AppUser saveUser(AppUser user){
       return userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    
    
    public ResponseEntity<?> addUser(AppUser userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        Role roleUse = roleRepository.findById(2).get();
        userInfo.setRole(roleUse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*   public ResponseEntity<Object> getUserAbonnement(int id){
        Optional<AppUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();

            List<Abonnement> UserAbonnements = abonnementRepository.findByEtudiant(user);
            var UserAbonnementsDTO = new UserAbonnementsDTO(UserAbonnements.size(), UserAbonnements);

            return ResponseEntity.ok().body(UserAbonnementsDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
    }
*/











    public ResponseEntity<Object> getUserAbonnement(int id){
        Optional<AppUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();

            List<Abonnement> UserAbonnements = abonnementRepository.findByEtudiant(user);
            var UserAbonnementsDTO = new UserAbonnementsDTO(UserAbonnements.size(), UserAbonnements);

            return ResponseEntity.ok().body(UserAbonnementsDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
    }

}