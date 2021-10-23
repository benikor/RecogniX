package com.github.kormosbenedek.RecogniX.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class CompletedTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private RequestTreatment requestTreatment;

    @OneToMany
    private List<Treatment> treatments;

    private boolean makeAutoTreatment;
    //doctor
    //date
    //treatmentResult
}
