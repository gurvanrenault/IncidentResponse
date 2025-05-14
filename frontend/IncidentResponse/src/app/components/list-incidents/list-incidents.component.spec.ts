import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListIncidentsComponent } from './list-incidents.component';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { Incident } from '../../shared/models/Incident';
import { IncidentService } from '../../shared/services/incidentService/incident.service';
import { of } from 'rxjs';

describe('ListIncidentsComponent', () => {
  let component: ListIncidentsComponent;
  let fixture: ComponentFixture<ListIncidentsComponent>;
  const incidentServiceSpy =jasmine.createSpyObj('IncidentService',['getAllIncidents']);
  beforeEach(async () => {
    incidentServiceSpy.getAllIncidents.and.returnValue(of({}));
    await TestBed.configureTestingModule({
      imports: [ListIncidentsComponent],
      providers: [ provideHttpClient(),
                  {provide: IncidentService,useValue:incidentServiceSpy}
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListIncidentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
