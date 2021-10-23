import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorEvaluationComponent } from './doctor-evaluation.component';

describe('DoctorEvaluationComponent', () => {
  let component: DoctorEvaluationComponent;
  let fixture: ComponentFixture<DoctorEvaluationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorEvaluationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
