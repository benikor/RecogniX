import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-symptoms',
  templateUrl: './symptoms.component.html',
  styleUrls: ['./symptoms.component.scss']
})
export class SymptomsComponent implements OnInit {

  @Input() symptoms: any;

  constructor() { }

  ngOnInit(): void {
  }

}
