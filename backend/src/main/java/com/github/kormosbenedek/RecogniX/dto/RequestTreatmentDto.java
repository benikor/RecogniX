package com.github.kormosbenedek.RecogniX.dto;

import com.github.kormosbenedek.RecogniX.enums.TreatmentStatus;
import lombok.Data;

@Data
public class RequestTreatmentDto {
    private Long id;
    private String patientName;
    private String symptomNames;
    private Integer severityScore;
    private TreatmentStatus status;
}
