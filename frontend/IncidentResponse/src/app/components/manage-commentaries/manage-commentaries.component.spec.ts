import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageCommentariesComponent } from './manage-commentaries.component';

describe('ManageCommentariesComponent', () => {
  let component: ManageCommentariesComponent;
  let fixture: ComponentFixture<ManageCommentariesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManageCommentariesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageCommentariesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
