import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewIncidentComponent } from './view-incident.component';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Incident } from '../../shared/models/Incident';
import { HttpClient, provideHttpClient } from '@angular/common/http';

describe('ViewIncidentComponent', () => {
  let component: ViewIncidentComponent;
  let fixture: ComponentFixture<ViewIncidentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewIncidentComponent],
      providers:[{
        provide: ActivatedRoute, useValue: {
          snapshot: { params: { id: 1 } }
        },

      
      },provideHttpClient()]
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
