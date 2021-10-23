import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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
    private route: ActivatedRoute,
    private backendHandlerService: BackendHandlerService
  ) { }

  ngOnInit(): void {
    this.getPatientById();
    this.getSymptompsById();
    this.getAutoTreatmentById();
  }

  getPatientById(): void {
    var id
    if (id = this.route.snapshot.paramMap.get('id'))
      this.backendHandlerService.getPatientById(+id).subscribe(patientData => this.patientData = patientData);
  }

  getSymptompsById(): void {
    var id
    if (id = this.route.snapshot.paramMap.get('id'))
      this.backendHandlerService.getSymptompsById(+id).subscribe(symptomData => this.symptomData = symptomData);
  }

  getAutoTreatmentById(): void {
    var id
    if (id = this.route.snapshot.paramMap.get('id'))
      this.backendHandlerService.getAutoTreatmentById(+id).subscribe(treatmentData => this.treatmentData = treatmentData);
  }

  
}
