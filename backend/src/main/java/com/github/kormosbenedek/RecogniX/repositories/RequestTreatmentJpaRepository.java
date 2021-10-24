package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.Patient;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface RequestTreatmentJpaRepository extends JpaRepository<RequestTreatment,Long> {
    public List<RequestTreatment> findAllByPatient(Patient patient);

}
