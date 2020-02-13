import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneAssignementComponent } from './one-assignement.component';

describe('OneAssignementComponent', () => {
  let component: OneAssignementComponent;
  let fixture: ComponentFixture<OneAssignementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneAssignementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneAssignementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
