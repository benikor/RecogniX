package com.github.kormosbenedek.RecogniX.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class AutoTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Symptom> symptoms;

    @OneToMany
    private List<Symptom> antisymptoms;


    private Integer minimumAge;
    private Integer maximumAge;


}
