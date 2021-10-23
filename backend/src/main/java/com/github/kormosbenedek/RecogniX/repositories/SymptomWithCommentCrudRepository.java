package com.github.kormosbenedek.RecogniX.repositories;

import com.github.kormosbenedek.RecogniX.entity.SymptomWithComment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SymptomWithCommentCrudRepository extends PagingAndSortingRepository<SymptomWithComment,Long> {
}
