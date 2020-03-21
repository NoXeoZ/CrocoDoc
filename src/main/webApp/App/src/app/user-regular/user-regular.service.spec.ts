import { TestBed } from '@angular/core/testing';

import { UserRegularService } from './user-regular.service';

describe('UserRegularService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserRegularService = TestBed.get(UserRegularService);
    expect(service).toBeTruthy();
  });
});
