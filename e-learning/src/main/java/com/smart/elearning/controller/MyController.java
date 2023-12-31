/*package com.smart.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.elearning.entity.Abonnement;
import com.smart.elearning.entity.Cours;
import com.smart.elearning.entity.User;

import com.smart.elearning.service.AbonnementService;
import com.smart.elearning.service.CoursService;
import com.smart.elearning.service.UserService;

@RestController
@RequestMapping("/api")
public class MyController {
    
    @Autowired
    private CoursService coursService;
    @Autowired
    private UserService userService;
    @Autowired
    private AbonnementService abonnementService;


    // Endpoints pour l'entité Cours
    @PostMapping("/cours")
    public Cours saveCours(@RequestBody Cours cours) {
    return coursService.saveCours(cours);
}

    @GetMapping("/cours")
    public List<Cours> getAllCours(){
        return coursService.getAllCours();
    }

    @GetMapping("/cour/{id}")
    public Cours getCoursById(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    @DeleteMapping("/cour/{id}")
    public void deleteCour(@PathVariable Long id) {
        coursService.deleteCours(id);
    }

    // Endpoints pour l'entité Abonnement

    @PostMapping("/abonnements")
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.saveAbonnement(abonnement);
    }
    
    @GetMapping("/abonnements")
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }

    @GetMapping("/abonnements/{id}")
    public Abonnement getAbonnementById(@PathVariable Long id) {
        return abonnementService.getAbonnementById(id);
    }

   

    @DeleteMapping("/abonnements/{id}")
    public void deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
    }

    // Endpoints pour l'entité User
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
*/