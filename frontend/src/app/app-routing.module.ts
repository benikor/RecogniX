import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorEvaluationComponent } from './doctor-evaluation/doctor-evaluation.component';
import { DoctorComponent } from './doctor/doctor.component';
import { LoginComponent } from './login/login.component';
import { PatientMainComponent } from './patient-main/patient-main.component';
import { PatientComponent } from './patient/patient.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'patient/main', component: PatientMainComponent},
  { path: 'patient/request', component: PatientComponent },
  { path: 'doctor', component: DoctorComponent },
  { path: 'doctor/evaluation', component: DoctorEvaluationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
