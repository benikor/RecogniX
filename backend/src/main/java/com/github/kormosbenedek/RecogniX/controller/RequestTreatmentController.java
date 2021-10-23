package com.github.kormosbenedek.RecogniX.controller;

import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.repositories.PatientCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import com.github.kormosbenedek.RecogniX.repositories.SymptomWithCommentCrudRepository;
import com.github.kormosbenedek.RecogniX.service.RequestTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requestTreatment")
public class RequestTreatmentController {
    private final RequestTreatmentService service;
    private final PatientCrudRepository patientCrudRepository;
    private final SymptomWithCommentCrudRepository symptomWithCommentCrudRepository;

    @GetMapping("")
    public String getAll(){
        return "szeva";
    }

    @PostMapping("")
    public ResponseEntity<RequestTreatment> saveOne(@RequestBody RequestTreatment requestTreatment){
        requestTreatment.setPatient(patientCrudRepository.findById(
                requestTreatment.getPatient().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));


        return new ResponseEntity<>(service.saveOne(requestTreatment), HttpStatus.OK);
    }
}
