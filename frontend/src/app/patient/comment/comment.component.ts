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
    this.outData.symptomWithComments.pop()
    for (let item of this.items) {
      var asd = {"id": item.id,"comment": ""}
      this.outData.symptomWithComments.push(asd)
    }
  }

  inputChanged(id: any, event: any){
    
    this.outData.symptomWithComments.forEach(element => {
      if (element.id == id)
       element.comment = event.target.value
    });
  }

  ngOnDestroy(): void {

    this.newItemEvent.emit(this.outData);
  }
 
}
