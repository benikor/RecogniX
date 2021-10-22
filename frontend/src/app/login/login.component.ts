import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  patient=false
  doctor=false

  constructor() { }

  ngOnInit(): void {
  }

  toPatient() {
    this.patient=true
    this.doctor=false
  }

  toDoctor() {
    this.patient=false
    this.doctor=true
  }
}
