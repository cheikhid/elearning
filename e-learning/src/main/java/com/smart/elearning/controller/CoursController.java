package com.smart.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.elearning.entity.Cours;
import com.smart.elearning.service.CoursService;

@RestController
@RequestMapping("/cour")
public class CoursController {
    @Autowired
    private CoursService coursService;


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

}