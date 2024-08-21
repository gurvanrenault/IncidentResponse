import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusIncidentInfoComponent } from './status-incident-info.component';

describe('StatutIncidentInfoComponent', () => {
  let component: StatusIncidentInfoComponent;
  let fixture: ComponentFixture<StatusIncidentInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatusIncidentInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatusIncidentInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
