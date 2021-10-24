package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.CompletedTreatment;
import com.github.kormosbenedek.RecogniX.entity.RequestTreatment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompletedTreatmentCrudRepository extends PagingAndSortingRepository<CompletedTreatment,Long> {
    public CompletedTreatment findByRequestTreatment(RequestTreatment requestTreatment);
}
