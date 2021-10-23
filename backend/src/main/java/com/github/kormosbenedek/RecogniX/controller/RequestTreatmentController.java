package com.github.kormosbenedek.RecogniX.controller;

import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.entity.SymptomWithComment;
import com.github.kormosbenedek.RecogniX.repositories.PatientCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import com.github.kormosbenedek.RecogniX.repositories.SymptomWithCommentCrudRepository;
import com.github.kormosbenedek.RecogniX.service.RequestTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.github.kormosbenedek.RecogniX.dto.RequestTreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.service.RequestTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.ArrayList;
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
}
