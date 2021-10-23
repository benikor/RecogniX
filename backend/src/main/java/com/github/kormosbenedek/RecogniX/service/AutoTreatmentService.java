package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.dto.TreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.*;
import com.github.kormosbenedek.RecogniX.enums.TreatmentRecommendation;
import com.github.kormosbenedek.RecogniX.repositories.AutoTreatmentCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import com.github.kormosbenedek.RecogniX.repositories.TreatmentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutoTreatmentService {
    private final TreatmentCrudRepository repository;
    private final AutoTreatmentCrudRepository autoTreatmentRepository;
    private final RequestTreatmentJpaRepository requestTreatmentRepository;

    public List<TreatmentDto> getAutotreatments(Long requestTreatmentId){
        RequestTreatment requestTreatment = requestTreatmentRepository.getById(requestTreatmentId);
        List<Symptom> symptomList = requestTreatment.getSymptomWithComments().stream().map(SymptomWithComment::getSymptom).collect(Collectors.toList());
        //lets do the filtering here
        List<AutoTreatment> autoTreatments = (List<AutoTreatment>) autoTreatmentRepository.findAll();
        autoTreatments.forEach(autoTreatment -> {

        });

        //first, return everythin as it is
        List<Treatment> treatments = (List<Treatment>) repository.findAll();

        return mapTreatmentToDto(treatments);
    }

    private List<TreatmentDto> mapTreatmentToDto(List<Treatment> treatmentList){
        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        treatmentList.forEach(treatment -> {
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

        List<Symptom> symptomList = completedTreatment.getRequestTreatment().getSymptomWithComments().stream().map(SymptomWithComment::getSymptom).collect(Collectors.toList());
        List<Treatment> treatments = completedTreatment.getTreatments();

        AutoTreatment autoTreatment = new AutoTreatment();
        autoTreatment.setSymptoms(symptomList);
        autoTreatment.setRecommendedTreatment(treatments);

        autoTreatment.setMinimumAge(null);
        autoTreatment.setMaximumAge(null);
        autoTreatment.setAntisymptoms(null);

        autoTreatmentRepository.save(autoTreatment);
    }

}
