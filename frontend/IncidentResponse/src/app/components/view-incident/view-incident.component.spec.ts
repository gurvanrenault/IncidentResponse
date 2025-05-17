import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewIncidentComponent } from './view-incident.component';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Incident } from '../../shared/models/Incident';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { IncidentService } from '../../shared/services/incidentService/incident.service';
import { of } from 'rxjs';
import { PriorityEnum } from '../../enums/PriorityEnum';
import { provideAnimations } from '@angular/platform-browser/animations';

describe('ViewIncidentComponent', () => {
  let component: ViewIncidentComponent;
  let fixture: ComponentFixture<ViewIncidentComponent>;
  const incidentServiceSpy =jasmine.createSpyObj('IncidentService',['getIncidentById']);
  beforeEach(async () => {
    incidentServiceSpy.getIncidentById.and.returnValue(of({"priority": PriorityEnum.P1}));
    await TestBed.configureTestingModule({
      imports: [ViewIncidentComponent],
      providers:[
        provideHttpClient(),
        provideAnimations(),
        {
        provide: ActivatedRoute, useValue: {
          snapshot: { params: { id: 1 } }
        }},
        {provide: IncidentService ,useValue:incidentServiceSpy}

      
      ]
    })
    .compileComponents();
    fixture = TestBed.createComponent(ViewIncidentComponent);
    component = fixture.componentInstance;
    component.ngOnInit()
    fixture.detectChanges();
  });

  it('should create', () => {
   
    expect(component).toBeTruthy();
  });
});
