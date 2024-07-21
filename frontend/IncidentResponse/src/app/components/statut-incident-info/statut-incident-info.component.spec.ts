import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatutIncidentInfoComponent } from './statut-incident-info.component';

describe('StatutIncidentInfoComponent', () => {
  let component: StatutIncidentInfoComponent;
  let fixture: ComponentFixture<StatutIncidentInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatutIncidentInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatutIncidentInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
