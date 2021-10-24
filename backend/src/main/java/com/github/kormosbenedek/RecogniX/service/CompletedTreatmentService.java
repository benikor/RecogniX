package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompletedTreatmentService {
        private final AutoTreatmentService autoTreatmentService;
    public void complete(CompletedTreatment completedTreatment){
        if (completedTreatment.isMakeAutoTreatment()){
        autoTreatmentService.generateDraftAutoTreatment(completedTreatment);}

        //NOTTODO save
    }

}
