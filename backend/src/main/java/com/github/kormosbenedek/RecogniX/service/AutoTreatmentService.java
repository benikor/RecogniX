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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Set<Treatment> recommendedTreatments = new HashSet<>();
        Set<Treatment> notRecommendedTreatments = new HashSet<>();
        List<AutoTreatment> autoTreatments = (List<AutoTreatment>) autoTreatmentRepository.findAll();
        autoTreatments.forEach(autoTreatment -> {
            if(symptomList.containsAll(autoTreatment.getSymptoms())){
                recommendedTreatments.addAll(autoTreatment.getRecommendedTreatments());
                notRecommendedTreatments.addAll(autoTreatment.getNotRecommendedTreatments());
            }
        });
        //take out the duplicates
        List<Treatment> allTreatments = (List<Treatment>) repository.findAll();
        allTreatments.removeAll(recommendedTreatments);
        allTreatments.removeAll(notRecommendedTreatments);

        //mapping to dtoList
        List<TreatmentDto> recommendedTreatmentDtos = List.copyOf(mapTreatmentToDto(recommendedTreatments));
        List<TreatmentDto> notRecommendedTreatmentDtos = List.copyOf(mapTreatmentToDto(notRecommendedTreatments));
        List<TreatmentDto> allTreatmentDtos = mapTreatmentToDto(allTreatments); //minus the other two list

        //coloring
        recommendedTreatmentDtos.forEach(treatmentDto -> treatmentDto.setRecommendation(TreatmentRecommendation.RECOMMENDED));
        allTreatmentDtos.forEach(treatmentDto -> treatmentDto.setRecommendation(TreatmentRecommendation.NEUTRAL));
        notRecommendedTreatmentDtos.forEach(treatmentDto -> treatmentDto.setRecommendation(TreatmentRecommendation.NOT_RECOMMENDED));

        //final assemble
        List<TreatmentDto> treatments = new ArrayList<>();
        treatments.addAll(recommendedTreatmentDtos);
        treatments.addAll(allTreatmentDtos);
        treatments.addAll(notRecommendedTreatmentDtos);


        return treatments;
    }

    private List<TreatmentDto> mapTreatmentToDto(Iterable<Treatment> treatmentList){
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
        autoTreatment.setRecommendedTreatments(treatments);

        autoTreatment.setMinimumAge(null);
        autoTreatment.setMaximumAge(null);
        autoTreatment.setAntisymptoms(null);

        autoTreatmentRepository.save(autoTreatment);
    }

}
