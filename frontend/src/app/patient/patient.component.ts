import { Component, OnInit } from '@angular/core';

import { BackendHandlerService } from '../backend-handler.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit {

  first=true

  dataFromServer: any
  dataToComment: any
  
  constructor(
    private backendHandlerService: BackendHandlerService
    ) { }

  ngOnInit(): void {
    this.getSymptomps();
  }

  getSymptomps(): void {
    this.backendHandlerService.getSymptomps().subscribe(this.dataFromServer);
    console.log(this.dataFromServer)
  }


  updateData(itemFromPatient: any) {
    this.dataToComment = itemFromPatient
  }

  onClick() {
    var next
    var back
    var submit

    this.first = !this.first;

    if (this.first) {
      if (next = document.getElementById("next")) {
        next.style.display = "block"
      }
      if (back = document.getElementById("back")) {
        back.style.display = "none"
      }
      if (submit = document.getElementById("submit")) {
        submit.style.display = "none"
      }
    } else {
      if (next = document.getElementById("next")) {
        next.style.display = "none"
      }
      if (back = document.getElementById("back")) {
        back.style.display = "block"
      if (submit = document.getElementById("submit")) {
        submit.style.display = "block"
      }
    }
  }

    


    console.log(this.dataToComment)

  }
}
