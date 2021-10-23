import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.scss']
})
export class DoctorComponent implements OnInit {

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
