import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneSpecialityComponent } from './one-speciality.component';

describe('OneSpecialityComponent', () => {
  let component: OneSpecialityComponent;
  let fixture: ComponentFixture<OneSpecialityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneSpecialityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneSpecialityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
