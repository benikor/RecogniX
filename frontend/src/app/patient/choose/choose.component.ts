import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-choose',
  templateUrl: './choose.component.html',
  styleUrls: ['./choose.component.scss']
})
export class ChooseComponent implements OnInit {

  @Input() items: any;
  @Output() newItemEvent = new EventEmitter<any>();
  symptomList = [{id:"", name:"", description:"", severity:""}];

  constructor() { }

  ngOnInit(): void {
    this.symptomList.pop();
  }

  onClick(index: any, item: any) {

    var symptomCard
    var symptomToDelete = -1;

    if (symptomCard = document.getElementById(index)) {
      if (!symptomCard.classList.contains("active")) {
        symptomCard.classList.add("active")
        this.symptomList.push({
          id: item.id,
          name: item.name,
          description: item.description,
          severity: item.severity
        });
      }
      else {
        symptomCard.classList.remove("active")
        this.symptomList.forEach(function (symptom, i) {
          if (symptom.id == index)
            symptomToDelete =i
        });

      }

      if (symptomToDelete > 0) {
        this.symptomList.splice(symptomToDelete, 1)
      }
      
      this.newItemEvent.emit(this.symptomList);
    }

    //console.log(this.symptomList)
  }
}
