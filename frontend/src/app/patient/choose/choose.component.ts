import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-choose',
  templateUrl: './choose.component.html',
  styleUrls: ['./choose.component.scss']
})
export class ChooseComponent implements OnInit {

  activelist = []
  active=false

  items = {
    "_embedded": {
        "symptoms": [
            {
                "name": "Headache",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/1"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/1"
                    }
                }
            },
            {
                "name": "Fatigue",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/2"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/2"
                    }
                }
            },
            {
                "name": "Skin redness",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/3"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/3"
                    }
                }
            },
            {
                "name": "Pain",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/4"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/4"
                    }
                }
            },
            {
                "name": "Loss of appetite",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/5"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/5"
                    }
                }
            },
            {
                "name": "Urinary retention",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/symptoms/6"
                    },
                    "symptom": {
                        "href": "http://localhost:8080/api/symptoms/6"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/symptoms"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/symptoms"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 6,
        "totalPages": 1,
        "number": 0
    }
}

  constructor() { }

  ngOnInit(): void {
  }

  onClick(index: any) {

    var symptom

    //activelist

    this.active = !this.active


    if (symptom = document.getElementById(index)) {
      if (!symptom.classList.contains("active")) {
        symptom.classList.add("active")
      }
      else {
        symptom.classList.remove("active")
      }
    }

    
  }
}
