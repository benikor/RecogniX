package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.Symptom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SymptomCrudRepository extends PagingAndSortingRepository<Symptom,Long> {
}
