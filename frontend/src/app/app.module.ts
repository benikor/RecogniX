import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { LoginComponent } from './login/login.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';
import { ChooseComponent } from './patient/choose/choose.component';
import { CommentComponent } from './patient/comment/comment.component';
import { PatientMainComponent } from './patient-main/patient-main.component';
import { DoctorEvaluationComponent } from './doctor-evaluation/doctor-evaluation.component';
import { PatientDataComponent } from './doctor-evaluation/patient-data/patient-data.component';
import { SymptomsComponent } from './doctor-evaluation/symptoms/symptoms.component';
import { TreatmentsComponent } from './doctor-evaluation/treatments/treatments.component';
import { PatientTreatmentsComponent } from './patient-treatments/patient-treatments.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    LoginComponent,
    PatientComponent,
    DoctorComponent,
    ChooseComponent,
    CommentComponent,
    PatientMainComponent,
    DoctorEvaluationComponent,
    PatientDataComponent,
    SymptomsComponent,
    TreatmentsComponent,
    PatientTreatmentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
