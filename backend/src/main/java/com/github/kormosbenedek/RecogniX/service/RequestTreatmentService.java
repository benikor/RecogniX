package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import lombok.RequiredArgsConstructor;
import com.github.kormosbenedek.RecogniX.dto.RequestTreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.entity.SymptomWithComment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestTreatmentService {

    private final RequestTreatmentJpaRepository repository;

    public List<RequestTreatmentDto> getAll(){

        List<RequestTreatment> requestTreatments = repository.findAll();
        List<RequestTreatmentDto> requestTreatmentDtos = new ArrayList<>();

        requestTreatments.forEach(requestTreatment -> {
            RequestTreatmentDto requestTreatmentDto = new RequestTreatmentDto();
            requestTreatmentDto.setId(requestTreatment.getId());
            requestTreatmentDto.setPatientName(requestTreatment.getPatient().getName());
            StringBuilder patientSymptomNames = new StringBuilder();
            Integer patientSymptomSeverity = 0;

            for (SymptomWithComment symptomWithComment : requestTreatment.getSymptomWithComments()) {
                patientSymptomNames.append(symptomWithComment.getSymptom().getName()).append(", ");
                patientSymptomSeverity += symptomWithComment.getSymptom().getSeverity();
            }
            requestTreatmentDto.setSymptomNames(patientSymptomNames.toString());
            requestTreatmentDto.setSeverityScore(patientSymptomSeverity);
            requestTreatmentDtos.add(requestTreatmentDto);
        });

    return requestTreatmentDtos;
    }
    public RequestTreatment saveOne(RequestTreatment requestTreatment){

        return repository.save(requestTreatment);
    }
}
