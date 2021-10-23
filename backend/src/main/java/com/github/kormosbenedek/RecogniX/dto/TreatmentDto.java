package com.github.kormosbenedek.RecogniX.dto;

import com.github.kormosbenedek.RecogniX.enums.TreatmentRecommendation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreatmentDto {
    private Long id;
    private String name;
    private String description;
    private TreatmentRecommendation recommendation;

 }
