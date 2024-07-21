import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrioriteInfoComponent } from './priorite-info.component';

describe('PrioriteInfoComponent', () => {
  let component: PrioriteInfoComponent;
  let fixture: ComponentFixture<PrioriteInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrioriteInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrioriteInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
