import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListIncidentsComponent } from './list-incidents.component';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';

describe('ListIncidentsComponent', () => {
  let component: ListIncidentsComponent;
  let fixture: ComponentFixture<ListIncidentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListIncidentsComponent],
      providers: [ provideHttpClient()]
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
