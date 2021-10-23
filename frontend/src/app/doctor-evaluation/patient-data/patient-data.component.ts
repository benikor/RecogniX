import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-patient-data',
  templateUrl: './patient-data.component.html',
  styleUrls: ['./patient-data.component.scss']
})
export class PatientDataComponent implements OnInit {

  @Input() patient: any;

  constructor() { }

  ngOnInit(): void {
  }

}
