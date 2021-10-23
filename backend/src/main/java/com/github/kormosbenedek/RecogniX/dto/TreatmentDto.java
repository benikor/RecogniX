package com.github.kormosbenedek.RecogniX.dto;

import com.github.kormosbenedek.RecogniX.enums.TreatmentRecommendation;
import lombok.Data;

@Data
public class TreatmentDto {
    private Long id;
    private String name;
    private String description;
    private TreatmentRecommendation recommendation;
}
