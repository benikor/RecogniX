import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient-main',
  templateUrl: './patient-main.component.html',
  styleUrls: ['./patient-main.component.scss']
})
export class PatientMainComponent implements OnInit {

  items = [
    1,
    2,
    3,
    4,
    5
  ]
  
  constructor() { }

  ngOnInit(): void {
  }

}
