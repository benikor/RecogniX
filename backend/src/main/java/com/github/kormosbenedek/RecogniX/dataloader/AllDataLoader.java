package com.github.kormosbenedek.RecogniX.dataloader;

import com.github.kormosbenedek.RecogniX.entity.Patient;
import com.github.kormosbenedek.RecogniX.repositories.PatientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllDataLoader implements CommandLineRunner {

    @Autowired
    PatientCrudRepository repository;

    public void run(String... args) {
        loadPatientData();
    }

    private void loadPatientData(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L,"Teszt Elek",18));
        patients.add(new Patient(2L,"Dummy Jhon",55));
        repository.saveAll(patients);
    }
}
