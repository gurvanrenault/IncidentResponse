import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriorityInfoComponent } from './priority-info.component';

describe('PrioriteInfoComponent', () => {
  let component: PriorityInfoComponent;
  let fixture: ComponentFixture<PriorityInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PriorityInfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriorityInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
