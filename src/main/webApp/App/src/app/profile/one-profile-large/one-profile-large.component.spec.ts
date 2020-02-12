import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneProfileLargeComponent } from './one-profile-large.component';

describe('OneProfileLargeComponent', () => {
  let component: OneProfileLargeComponent;
  let fixture: ComponentFixture<OneProfileLargeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneProfileLargeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneProfileLargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
