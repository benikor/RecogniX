package com.github.kormosbenedek.RecogniX.controller;

import com.github.kormosbenedek.RecogniX.dto.TreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.Treatment;
import com.github.kormosbenedek.RecogniX.service.AutoTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autoTreatment")
public class AutoTreatmentController {
    private final AutoTreatmentService service;

    @GetMapping("/{requestTreatmentId}")
    public ResponseEntity<List<TreatmentDto>> getAutotreatments(@PathVariable Long requestTreatmentId){
        return new ResponseEntity<>(service.getAutotreatments(requestTreatmentId), HttpStatus.OK);
    }
}
