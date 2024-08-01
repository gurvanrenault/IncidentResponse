import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentaryComponent } from './commentary.component';

describe('CommentaryComponent', () => {
  let component: CommentaryComponent;
  let fixture: ComponentFixture<CommentaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CommentaryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommentaryComponent);
    component = fixture.componentInstance;
    component.commentary= {id:42,date : new Date(), user:1,description:'TEST'}
    
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
