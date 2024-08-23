import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusSnackbarComponent } from './status-snackbar.component';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';

describe('StatusSnackbarComponent', () => {
  let component: StatusSnackbarComponent;
  let fixture: ComponentFixture<StatusSnackbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatusSnackbarComponent],
      providers: [{
        provide: MatSnackBarRef,
        useValue: {}
        }, {
        provide: MAT_SNACK_BAR_DATA,
        useValue: {} // Add any data you wish to test if it is passed/used correctly
        }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatusSnackbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
