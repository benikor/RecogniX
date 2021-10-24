package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import com.github.kormosbenedek.RecogniX.entity.Treatment;
import com.github.kormosbenedek.RecogniX.repositories.CompletedTreatmentCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import com.github.kormosbenedek.RecogniX.repositories.TreatmentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompletedTreatmentService {
    private final AutoTreatmentService autoTreatmentService;
    private final RequestTreatmentJpaRepository requestTreatmentJpaRepository;
    private final CompletedTreatmentCrudRepository completedTreatmentCrudRepository;
    private final TreatmentCrudRepository treatmentCrudRepository;

    public CompletedTreatment complete(CompletedTreatment completedTreatment) {
        completedTreatment.setRequestTreatment(requestTreatmentJpaRepository.findById(completedTreatment.getRequestTreatment().getId()).orElseThrow());
        List<Treatment> incomingTreatments = completedTreatment.getTreatments();
        List<Treatment> treatments = new ArrayList<>();
        incomingTreatments.forEach(incomingTreatment -> {
            Treatment treatment =new Treatment();
            treatment.setName(incomingTreatment.getName());
            treatment.setDescription(incomingTreatment.getDescription());
            treatments.add(treatment);
        });
        completedTreatment.setTreatments(treatments);
        treatmentCrudRepository.saveAll(treatments);
        if (completedTreatment.isMakeAutoTreatment()) {
            autoTreatmentService.generateDraftAutoTreatment(completedTreatment);
        }
        return completedTreatmentCrudRepository.save(completedTreatment);

    }


}
