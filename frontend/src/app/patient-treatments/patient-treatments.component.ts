import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { BackendHandlerService } from '../backend-handler.service';

@Component({
  selector: 'app-patient-treatments',
  templateUrl: './patient-treatments.component.html',
  styleUrls: ['./patient-treatments.component.scss']
})
export class PatientTreatmentsComponent implements OnInit {

  items: any
  
  constructor(
    private route: ActivatedRoute,
    private backendHandlerService: BackendHandlerService
  ) {}

  ngOnInit(): void {
    this.getRequestTreatmentByPatientId();
  }

  getRequestTreatmentByPatientId(): void {
    var id
    if (id = this.route.snapshot.paramMap.get('id'))
      this.backendHandlerService.getRequestTreatmentByPatientId(+id).subscribe(items => this.items = items);
  }
}
