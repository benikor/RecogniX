import { TestBed } from '@angular/core/testing';

import { BackendHandlerService } from './backend-handler.service';

describe('BackendHandlerService', () => {
  let service: BackendHandlerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackendHandlerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
