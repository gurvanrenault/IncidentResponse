import { TestBed } from '@angular/core/testing';

import { CommentaryService } from './commentary.service';
import { provideHttpClient } from '@angular/common/http';

describe('CommentaryService', () => {
  let service: CommentaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers:[  provideHttpClient()]
    });
    service = TestBed.inject(CommentaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
