import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit {

  first=true
  dataFromServer = {
    "_embedded": {
        "symptoms": [
            {
                "id": 1,
                "name": "Headache",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 2,
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
                "id": 2,
                "name": "Fatigue",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 1,
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
                "id": 3,
                "name": "Skin redness",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 2,
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
                "id": 4,
                "name": "Pain",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 3,
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
                "id": 5,
                "name": "Loss of appetite",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 3,
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
                "id": 6,
                "name": "Urinary retention",
                "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "severity": 5,
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
  dataToComment: any
  
  constructor() { }

  ngOnInit(): void {
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
