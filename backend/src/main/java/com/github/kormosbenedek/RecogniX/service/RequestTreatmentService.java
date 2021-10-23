package com.github.kormosbenedek.RecogniX.service;

import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import com.github.kormosbenedek.RecogniX.repositories.RequestTreatmentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestTreatmentService {

    private final RequestTreatmentJpaRepository repository;

    public void getAll(){

    }
    public RequestTreatment saveOne(RequestTreatment requestTreatment){

        return repository.save(requestTreatment);
    }
}
