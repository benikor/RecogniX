package com.github.kormosbenedek.RecogniX.controller;

import com.github.kormosbenedek.RecogniX.dto.SymptomWithCommentDto;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.entity.SymptomWithComment;
import com.github.kormosbenedek.RecogniX.repositories.PatientCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.SymptomWithCommentCrudRepository;
import com.github.kormosbenedek.RecogniX.service.RequestTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.kormosbenedek.RecogniX.dto.RequestTreatmentDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requestTreatment")
public class RequestTreatmentController {
    private final RequestTreatmentService service;
    private final PatientCrudRepository patientCrudRepository;
    private final SymptomWithCommentCrudRepository symptomWithCommentCrudRepository;

    @GetMapping("")
    public ResponseEntity<List<RequestTreatmentDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<RequestTreatment> saveOne(@RequestBody RequestTreatment requestTreatment){

        return new ResponseEntity<>(service.saveOne(requestTreatment), HttpStatus.OK);
    }

    @GetMapping("/{id}/symptoms")
    public ResponseEntity<List<SymptomWithCommentDto>> getById(@PathVariable Long id) {

        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}
