import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageIncidentsComponent } from './manage-incidents.component';
import { MAT_DIALOG_DATA, MAT_DIALOG_DEFAULT_OPTIONS, MatDialogRef } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { provideHttpClient } from '@angular/common/http';

describe('ManageIncidentsComponent', () => {
  let component: ManageIncidentsComponent;
  let fixture: ComponentFixture<ManageIncidentsComponent>;
  const matDialogSpy = jasmine.createSpyObj('MatDialogRef', ['onNoClick', 'closeDialog']);
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManageIncidentsComponent, BrowserAnimationsModule,],
      providers: [
        provideHttpClient(),
        { provide: MatDialogRef, useValue: matDialogSpy },

      ]
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
