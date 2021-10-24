package com.github.kormosbenedek.RecogniX.controller;

import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import com.github.kormosbenedek.RecogniX.service.CompletedTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/completedTreatment")
public class CompletedTreatmentController {

    private final CompletedTreatmentService service;
    @PostMapping("")
    public ResponseEntity<CompletedTreatment> complete(@RequestBody CompletedTreatment completedTreatment){
        return new ResponseEntity<>(service.complete(completedTreatment),HttpStatus.OK);
    }
}
