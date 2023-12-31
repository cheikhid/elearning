package com.smart.elearning.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.elearning.utils.Constants;

import com.smart.elearning.entity.AppUser;
import com.smart.elearning.service.UserService;


@RestController
@RequestMapping(Constants.APP_ROOT+Constants.USER)
public class UserController {
    @Autowired
    private UserService userService;
    
    

    // Endpoints pour l'entité User
    @PostMapping
    public AppUser saveUser(@RequestBody AppUser user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

 /*    @GetMapping("user-abonnement/{idUser}")
    public ResponseEntity<Object> getUserAbonnement(@PathVariable Long id){
        return getUserAbonnement(id);
    }*/






    @GetMapping("/{id}/abonnements")
    public ResponseEntity<Object> getUserAbonnement(@PathVariable int id) {
        return userService.getUserAbonnement(id);
    }

}