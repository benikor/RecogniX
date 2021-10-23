package com.github.kormosbenedek.RecogniX.dataloader;

import com.github.kormosbenedek.RecogniX.entity.Patient;
import com.github.kormosbenedek.RecogniX.entity.Symptom;
import com.github.kormosbenedek.RecogniX.entity.Treatment;
import com.github.kormosbenedek.RecogniX.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllDataLoader implements CommandLineRunner {

    @Autowired
    PatientCrudRepository patientCrudRepository;
    @Autowired
    SymptomCrudRepository symptomCrudRepository;
    @Autowired
    TreatmentCrudRepository treatmentCrudRepository;
    @Autowired
    RequestTreatmentCrudRepository requestTreatmentCrudRepository;
    @Autowired
    CompletedTreatmentCrudRepository completedTreatmentCrudRepository;
    @Autowired
    AutoTreatmentCrudRepository autoTreatmentCrudRepository;
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Magna etiam tempor orci eu lobortis elementum nibh tellus. Quis varius quam quisque id diam vel quam elementum pulvinar. Mauris pellentesque pulvinar pellentesque habitant. Velit sed ullamcorper morbi tincidunt ornare massa eget. Nibh ipsum consequat nisl vel pretium lectus quam id. Accumsan tortor posuere ac ut consequat semper viverra.";

    public void run(String... args) {
        loadPatientData();
        loadSymptomData();
        loadTreatmentData();
    }

    private void loadPatientData(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L,"Teszt Elek",18));
        patients.add(new Patient(2L,"Dummy Jhon",55));
        patientCrudRepository.saveAll(patients);
    }
    private void loadSymptomData(){
        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom(1L,"Headache",loremIpsum));
        symptoms.add(new Symptom(2L,"Fatigue",loremIpsum));
        symptoms.add(new Symptom(3L,"Skin redness",loremIpsum));
        symptoms.add(new Symptom(4L,"Pain",loremIpsum));
        symptoms.add(new Symptom(5L,"Loss of appetite",loremIpsum));
        symptoms.add(new Symptom(6L,"Urinary retention",loremIpsum));
        symptomCrudRepository.saveAll(symptoms);
    }
    private void loadTreatmentData(){
        List<Treatment> treatments = new ArrayList<>();
        treatments.add(new Treatment(1L,"Take pills","1 x AlgoFlex 400mg, twice daily"));
        treatments.add(new Treatment(2L,"Rest","Take more rest until it ease"));
        treatments.add(new Treatment(3L,"Call Ambulance","Call the ambulance immediately!"));
        treatmentCrudRepository.saveAll(treatments);
    }
}
