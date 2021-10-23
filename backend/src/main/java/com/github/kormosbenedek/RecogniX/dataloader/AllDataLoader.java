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
    RequestTreatmentJpaRepository requestTreatmentJpaRepository;
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
        loadAutoTreatmentData();
    }



    private void loadPatientData() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(0L, "Kovacs Facundo", 25,"Chemotherapy for small cell lung cancer", "none"));
        patients.add(new Patient(1L, "Teszt Elek", 18,"Radiation therapy for small cell prostate cancer","Aspirin"));
        patients.add(new Patient(2L, "Dummy Jhon", 55,"Radiation therapy for non-small cell lung cancer","none"));
        patientCrudRepository.saveAll(patients);
    }

    private void loadSymptomData() {
        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom(0L, "Fever", loremIpsum,3));
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

        symptomWithComments.add(new SymptomWithComment(1L,symptomCrudRepository.findById(1L).orElseThrow(),"comment for headache"));
        symptomWithComments.add(new SymptomWithComment(2L,symptomCrudRepository.findById(2L).orElseThrow(),"comment for fatigue"));
        symptomWithComments.add(new SymptomWithComment(3L,symptomCrudRepository.findById(3L).orElseThrow(),"comment for skin redness"));
        symptomWithComments.add(new SymptomWithComment(4L,symptomCrudRepository.findById(4L).orElseThrow(),"comment for pain"));
        symptomWithComments.add(new SymptomWithComment(5L,symptomCrudRepository.findById(5L).orElseThrow(),"comment for loss of appetite"));
        symptomWithComments.add(new SymptomWithComment(6L,symptomCrudRepository.findById(6L).orElseThrow(),"comment for urinary retention"));
        symptomWithCommentCrudRepository.saveAll(symptomWithComments);
    }

    private void loadTreatmentData() {
        List<Treatment> treatments = new ArrayList<>();
        treatments.add(new Treatment(0L, "Take appointment", "Call your doctor for an appointment"));
        treatments.add(new Treatment(1L, "Take pills", "1 x AlgoFlex 400mg, twice daily"));
        treatments.add(new Treatment(2L, "Rest", "Take more rest until it ease"));
        treatments.add(new Treatment(3L, "Call Ambulance", "Call the ambulance immediately!"));
        treatmentCrudRepository.saveAll(treatments);
    }

    private void loadRequestTreatmentData() {

        List<List<SymptomWithComment>> symptomLists = new ArrayList<>();
        symptomLists.add(new ArrayList<>());
        symptomLists.get(0).add(symptomWithCommentCrudRepository.findById(1L).orElseThrow());
        symptomLists.get(0).add(symptomWithCommentCrudRepository.findById(3L).orElseThrow());
        symptomLists.add(new ArrayList<>());
        symptomLists.get(1).add(symptomWithCommentCrudRepository.findById(4L).orElseThrow());
        symptomLists.get(1).add(symptomWithCommentCrudRepository.findById(5L).orElseThrow());
        symptomLists.add(new ArrayList<>());
        symptomLists.get(2).add(symptomWithCommentCrudRepository.findById(6L).orElseThrow());

        List<RequestTreatment> requestTreatments = new ArrayList<>();

        requestTreatments.add(new RequestTreatment(
                1L,
                patientCrudRepository.findById(1L).orElseThrow(),
                symptomLists.get(0)));

        requestTreatments.add(new RequestTreatment(
                2L,
                patientCrudRepository.findById(1L).orElseThrow(),
                symptomLists.get(1)));

        requestTreatments.add(new RequestTreatment(
                3L,
                patientCrudRepository.findById(1L).orElseThrow(),
                symptomLists.get(2)));

        requestTreatmentJpaRepository.saveAll(requestTreatments);
    }
    private void loadAutoTreatmentData() {
        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(symptomCrudRepository.findById(1L).orElseThrow());
        List<AutoTreatment> autoTreatments = new ArrayList<>();

        autoTreatments.add(new AutoTreatment(
                0L,
                symptoms,
                null,
                8,
                120,
                treatmentCrudRepository.findById(1L).orElseThrow(),
                null));
        autoTreatmentCrudRepository.saveAll(autoTreatments);
    }

}
