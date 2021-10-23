package com.github.kormosbenedek.RecogniX.dataloader;

import com.github.kormosbenedek.RecogniX.entity.*;
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
    SymptomWithCommentCrudRepository symptomWithCommentCrudRepository;
    @Autowired
    TreatmentCrudRepository treatmentCrudRepository;
    @Autowired
    RequestTreatmentCrudRepository requestTreatmentCrudRepository;
    @Autowired
    CompletedTreatmentCrudRepository completedTreatmentCrudRepository;
    @Autowired
    AutoTreatmentCrudRepository autoTreatmentCrudRepository;
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    public void run(String... args) {
        loadPatientData();
        loadSymptomData();
        loadSymptomWithCommentData();
        loadTreatmentData();
        loadRequestTreatmentData();
    }

    private void loadPatientData() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Teszt Elek", 18));
        patients.add(new Patient(2L, "Dummy Jhon", 55));
        patientCrudRepository.saveAll(patients);
    }

    private void loadSymptomData() {
        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom(1L, "Headache", loremIpsum,2));
        symptoms.add(new Symptom(2L, "Fatigue", loremIpsum,1));
        symptoms.add(new Symptom(3L, "Skin redness", loremIpsum,2));
        symptoms.add(new Symptom(4L, "Pain", loremIpsum,3));
        symptoms.add(new Symptom(5L, "Loss of appetite", loremIpsum,3));
        symptoms.add(new Symptom(6L, "Urinary retention", loremIpsum,5));
        symptomCrudRepository.saveAll(symptoms);
    }
    private void loadSymptomWithCommentData() {
        List<SymptomWithComment> symptomWithComments = new ArrayList<>();
        symptomWithComments.add(new SymptomWithComment(1L,symptomCrudRepository.findById(1L).get(),"comment for headache"));
        symptomWithComments.add(new SymptomWithComment(2L,symptomCrudRepository.findById(2L).get(),"comment for fatigue"));
        symptomWithComments.add(new SymptomWithComment(3L,symptomCrudRepository.findById(3L).get(),"comment for skin redness"));
        symptomWithComments.add(new SymptomWithComment(4L,symptomCrudRepository.findById(4L).get(),"comment for pain"));
        symptomWithComments.add(new SymptomWithComment(5L,symptomCrudRepository.findById(5L).get(),"comment for loss of appetite"));
        symptomWithComments.add(new SymptomWithComment(6L,symptomCrudRepository.findById(6L).get(),"comment for urinary retention"));
        symptomWithCommentCrudRepository.saveAll(symptomWithComments);
    }

    private void loadTreatmentData() {
        List<Treatment> treatments = new ArrayList<>();
        treatments.add(new Treatment(1L, "Take pills", "1 x AlgoFlex 400mg, twice daily"));
        treatments.add(new Treatment(2L, "Rest", "Take more rest until it ease"));
        treatments.add(new Treatment(3L, "Call Ambulance", "Call the ambulance immediately!"));
        treatmentCrudRepository.saveAll(treatments);
    }

    private void loadRequestTreatmentData() {

        List<List<SymptomWithComment>> symptomLists = new ArrayList<>();
        symptomLists.add(new ArrayList<>());
        symptomLists.get(0).add(symptomWithCommentCrudRepository.findById(1L).get());
        symptomLists.get(0).add(symptomWithCommentCrudRepository.findById(3L).get());
        symptomLists.add(new ArrayList<>());
        symptomLists.get(1).add(symptomWithCommentCrudRepository.findById(4L).get());
        symptomLists.get(1).add(symptomWithCommentCrudRepository.findById(5L).get());
        symptomLists.add(new ArrayList<>());
        symptomLists.get(2).add(symptomWithCommentCrudRepository.findById(6L).get());

        List<RequestTreatment> requestTreatments = new ArrayList<>();

        requestTreatments.add(new RequestTreatment(
                1L,
                patientCrudRepository.findById(1L).get(),
                symptomLists.get(0)));

        requestTreatments.add(new RequestTreatment(
                2L,
                patientCrudRepository.findById(1L).get(),
                symptomLists.get(1)));

        requestTreatments.add(new RequestTreatment(
                3L,
                patientCrudRepository.findById(1L).get(),
                symptomLists.get(2)));

        requestTreatmentCrudRepository.saveAll(requestTreatments);
    }

}
