import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientTreatmentsComponent } from './patient-treatments.component';

describe('PatientTreatmentsComponent', () => {
  let component: PatientTreatmentsComponent;
  let fixture: ComponentFixture<PatientTreatmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientTreatmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientTreatmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
