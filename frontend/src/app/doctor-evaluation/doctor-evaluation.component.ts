import { Component, OnInit } from '@angular/core';

import { BackendHandlerService } from '../backend-handler.service';

@Component({
  selector: 'app-doctor-evaluation',
  templateUrl: './doctor-evaluation.component.html',
  styleUrls: ['./doctor-evaluation.component.scss']
})
export class DoctorEvaluationComponent implements OnInit {

  patientData: any
  symptomData: any
  treatmentData: any

  constructor(
    private backendHandlerService: BackendHandlerService
  ) { }

  ngOnInit(): void {
    this.getPatientById();
    this.getSymptompsById();
    this.getAutoTreatment();
  }

  getPatientById(): void {
    this.backendHandlerService.getPatientById().subscribe(patientData => this.patientData = patientData);
  }

  getSymptompsById(): void {
    this.backendHandlerService.getSymptompsById().subscribe(symptomData => this.symptomData = symptomData);
  }

  getAutoTreatment(): void {
    this.backendHandlerService.getAutoTreatment().subscribe(treatmentData => this.treatmentData = treatmentData);
  }
}
