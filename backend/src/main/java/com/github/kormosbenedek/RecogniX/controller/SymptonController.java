package com.github.kormosbenedek.RecogniX.controller;


import com.github.kormosbenedek.RecogniX.entity.Symptom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/symptoms")
public class SymptonController {

    @GetMapping("/{id}")
    public ResponseEntity<Symptom> getOne (@PathVariable Long id){
        return new ResponseEntity<>(new Symptom(1L,"Diarrhea","!Constipation"),HttpStatus.OK);
    }
}
