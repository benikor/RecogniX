import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {

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
