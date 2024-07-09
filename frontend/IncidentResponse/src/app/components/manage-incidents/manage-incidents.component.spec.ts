import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageIncidentsComponent } from './manage-incidents.component';

describe('ManageIncidentsComponent', () => {
  let component: ManageIncidentsComponent;
  let fixture: ComponentFixture<ManageIncidentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManageIncidentsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageIncidentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
