package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientCrudRepository extends PagingAndSortingRepository<Patient,Long> {
}
