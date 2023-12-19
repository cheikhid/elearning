package com.smart.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.elearning.dao.CoursRepository;
import com.smart.elearning.entity.Cours;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public List<Cours> getAllCours(){
        return coursRepository.findAll();
    }

    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Cours saveCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}