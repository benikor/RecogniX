import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-treatments',
  templateUrl: './treatments.component.html',
  styleUrls: ['./treatments.component.scss']
})
export class TreatmentsComponent implements OnInit {

  @Input() treatments: any;
  @Output() newItemEvent = new EventEmitter<any>();

  outData = {
    "requestTreatment":{"id": this.route.snapshot.paramMap.get('id')},
    "makeAutoTreatment": true,
    "treatments":[
        {"id":11,
        "name": "i modified dis",
        "description": "And this"
        }]
  }
  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.outData.treatments.pop()
  }


  onClick(id: string, button: any) {

    if (button.textContent == "Add") {

      var name
      var description
      
      var data= {"id":11,
        "name": "i modified dis",
        "description": "And this"
      }
  
      button.textContent = "Remove"
      
      data.id=+id
      if (name = document.getElementById(id + "-name"))
        if (name.textContent)
          data.name = name.textContent
      if (description = document.getElementById(id + "-description"))
        if (description.textContent)
          data.description = description.textContent

      this.outData.treatments.push(data)
      

    } else {
      var treatmentToDelete = -1

      button.textContent = "Add"

      this.outData.treatments.forEach(function (treatment, i: number) {
        if (treatment.id == +id)
          treatmentToDelete =i
      });
      this.outData.treatments.splice(treatmentToDelete, 1)
    }

    this.newItemEvent.emit(this.outData);

  }



}
