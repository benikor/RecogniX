import { Component, OnInit, Input, Output, EventEmitter  } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {

  @Input() items: any;
  @Output() newItemEvent = new EventEmitter<any>();

  outData= {
    "patient": {
        "id": this.route.snapshot.paramMap.get('id')
    },
    "symptomWithComments": [
      {
        "id": 0,
        "comment":"nope"
      }
    ]
}

  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    console.log(this.outData)
    this.dataTransfer()
    console.log("Data")
    console.log(this.outData)
  }

  dataTransfer() {
    this.outData.symptomWithComments.pop()
    this.items.array.forEach(function (this: any, element:any) {
      this.outData.symptomWithComments.push(element.id,"")
      
    });
  }


  inputChanged(id: any, event: any){
    
    console.log(id + " " + event.target.value)

    this.newItemEvent.emit();
  }



}
