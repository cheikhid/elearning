package com.smart.elearning.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.elearning.utils.Constants;

import com.smart.elearning.entity.Cours;
import com.smart.elearning.service.CoursService;

@RestController
@RequestMapping(Constants.APP_ROOT+Constants.COURS)
public class CoursController {
    @Autowired
    private CoursService coursService;


    // Endpoints pour l'entité Cours
    @PostMapping
    public Cours saveCours(@RequestBody Cours cours) {
    return coursService.saveCours(cours);
}

    @GetMapping
    public List<Cours> getAllCours(){
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCour(@PathVariable Long id) {
        coursService.deleteCours(id);
    }

}