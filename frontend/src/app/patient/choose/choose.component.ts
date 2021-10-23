import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-choose',
  templateUrl: './choose.component.html',
  styleUrls: ['./choose.component.scss']
})
export class ChooseComponent implements OnInit {

  items = [
    1,
    2,
    3,
    4,
    5,
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
