package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.dto.SymptomWithCommentDto;
import com.github.kormosbenedek.RecogniX.entity.*;
import com.github.kormosbenedek.RecogniX.repositories.CompletedTreatmentCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.PatientCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import com.github.kormosbenedek.RecogniX.repositories.SymptomCrudRepository;
import com.github.kormosbenedek.RecogniX.repositories.SymptomWithCommentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.github.kormosbenedek.RecogniX.dto.RequestTreatmentDto;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.entity.SymptomWithComment;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestTreatmentService {

    private final RequestTreatmentJpaRepository repository;
    private final PatientCrudRepository patientCrudRepository;
    private final SymptomWithCommentCrudRepository symptomWithCommentCrudRepository;
    private final CompletedTreatmentCrudRepository completedTreatmentCrudRepository;
    private final SymptomCrudRepository symptomCrudRepository;

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
            requestTreatmentDto.setStatus(requestTreatment.getStatus());
            requestTreatmentDtos.add(requestTreatmentDto);
        });

    return requestTreatmentDtos;
    }
    public RequestTreatment saveOne(RequestTreatment requestTreatment){

        requestTreatment.setPatient(patientCrudRepository.findById(
                requestTreatment.getPatient().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        List<SymptomWithComment> idOnlySymptomlist = requestTreatment.getSymptomWithComments();
        requestTreatment.setSymptomWithComments(new ArrayList<>());

        List<SymptomWithComment> fullSymptomlist = new ArrayList<>();
        idOnlySymptomlist.forEach(symptomWithComment -> {
            Symptom symptom = symptomCrudRepository.findById(symptomWithComment.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            fullSymptomlist.add(new SymptomWithComment(symptom, symptomWithComment.getComment()));
        });

        requestTreatment.setSymptomWithComments(fullSymptomlist);
        symptomWithCommentCrudRepository.saveAll(requestTreatment.getSymptomWithComments());
        return repository.save(requestTreatment);
    }

    public List<SymptomWithCommentDto> getSymptomsWithCommentsDtoById(Long id) {
        List<SymptomWithComment> symptomWithComments = repository.findById(id).orElseThrow().getSymptomWithComments();
        List<SymptomWithCommentDto> symptomWithCommentDtos = new ArrayList<>();
        symptomWithComments.forEach(symptomWithComment -> {
            SymptomWithCommentDto symptomWithCommentDto = new SymptomWithCommentDto();
            symptomWithCommentDto.setId(symptomWithComment.getId());
            symptomWithCommentDto.setSymptomName(symptomWithComment.getSymptom().getName());
            symptomWithCommentDto.setComment(symptomWithComment.getComment());
            symptomWithCommentDtos.add(symptomWithCommentDto);
        });
        return symptomWithCommentDtos;
    }

    public Patient getPatientId(Long id) {
        return repository.findById(id).orElseThrow().getPatient();
    }

    public List<Treatment> getTreatmentsById(Long id) {
        return completedTreatmentCrudRepository.findById(id).orElseThrow().getTreatments();
    }
}
