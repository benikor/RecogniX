package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.dto.TreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.AutoTreatment;
import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import com.github.kormosbenedek.RecogniX.entity.Treatment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoTreatmentService {

    public List<TreatmentDto> getAutotreatments(Long requestTreatmentId){
        //lets do the filtering here
        //TODO return everythin
    }


    public void generateDraftAutoTreatment(CompletedTreatment completedTreatment){
        //just map and save the thingies
    }

}
