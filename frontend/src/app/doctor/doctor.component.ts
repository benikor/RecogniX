import { Component, OnInit } from '@angular/core';

import { BackendHandlerService } from '../backend-handler.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.scss']
})
export class DoctorComponent implements OnInit {

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
