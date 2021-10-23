package com.github.kormosbenedek.RecogniX.dto;

import lombok.Data;

@Data
public class SymptomWithCommentDto {
    private Long id;
    private String symptomName;
    private String comment;
}
