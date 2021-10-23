package com.github.kormosbenedek.RecogniX.entity;

import com.github.kormosbenedek.RecogniX.enums.TreatmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class RequestTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;
    @ManyToMany
    private List<SymptomWithComment> symptomWithComments;

    private TreatmentStatus status;
}
