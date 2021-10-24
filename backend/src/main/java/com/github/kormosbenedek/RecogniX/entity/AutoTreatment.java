package com.github.kormosbenedek.RecogniX.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AutoTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Symptom> symptoms;

    @ManyToMany
    private List<Symptom> antisymptoms;

    private Integer minimumAge;
    private Integer maximumAge;

    @ManyToMany
    private List<Treatment> recommendedTreatments;

    @ManyToMany
    private List<Treatment> notRecommendedTreatments;
}
