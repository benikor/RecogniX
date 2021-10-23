package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.Treatment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreatmentCrudRepository extends PagingAndSortingRepository<Treatment,Long> {
}
