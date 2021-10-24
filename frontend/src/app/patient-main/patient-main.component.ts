import { Component, OnInit } from '@angular/core';

import { BackendHandlerService } from '../backend-handler.service';

@Component({
  selector: 'app-patient-main',
  templateUrl: './patient-main.component.html',
  styleUrls: ['./patient-main.component.scss']
})
export class PatientMainComponent implements OnInit {

  items: any
  
  constructor(
    private backendHandlerService: BackendHandlerService
  ) {}

  ngOnInit(): void {
    this.getRequestTreatment();
  }

  getRequestTreatment(): void {
    this.backendHandlerService.getRequestTreatment().subscribe(items => this.items = items);
  }

}
