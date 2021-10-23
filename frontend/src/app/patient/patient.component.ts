import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit {

  first=true

  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    this.first = !this.first;
  }
}
