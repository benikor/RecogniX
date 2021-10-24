import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorEvaluationComponent } from './doctor-evaluation/doctor-evaluation.component';
import { DoctorComponent } from './doctor/doctor.component';
import { LoginComponent } from './login/login.component';
import { PatientMainComponent } from './patient-main/patient-main.component';
import { PatientTreatmentsComponent } from './patient-treatments/patient-treatments.component';
import { PatientComponent } from './patient/patient.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'patient/main', component: PatientMainComponent},
  { path: 'patient/request', component: PatientComponent },
  { path: 'patient/treatment/:id', component: PatientTreatmentsComponent},
  { path: 'doctor', component: DoctorComponent },
  { path: 'doctor/evaluation/:id', component: DoctorEvaluationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
