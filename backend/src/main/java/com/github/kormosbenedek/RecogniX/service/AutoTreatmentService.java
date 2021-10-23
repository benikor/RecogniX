package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.dto.TreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.AutoTreatment;
import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import com.github.kormosbenedek.RecogniX.entity.Treatment;
import com.github.kormosbenedek.RecogniX.enums.TreatmentRecommendation;
import com.github.kormosbenedek.RecogniX.repositories.TreatmentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoTreatmentService {
    private final TreatmentCrudRepository repository;

    public List<TreatmentDto> getAutotreatments(Long requestTreatmentId){
        //lets do the filtering here

        //first, return everythin as it is
        List<Treatment> treatments = (List<Treatment>) repository.findAll();
        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        treatments.forEach(treatment -> {
            TreatmentDto treatmentDto = new TreatmentDto(
                    treatment.getId(),
                    treatment.getName(),
                    treatment.getDescription(),
                    TreatmentRecommendation.NEUTRAL);
            treatmentDtos.add(treatmentDto);
        });

        return treatmentDtos;
    }


    public void generateDraftAutoTreatment(CompletedTreatment completedTreatment){
        //just map and save the thingies
    }

}
