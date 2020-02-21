import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSpecialityComponent } from './edit-speciality.component';

describe('EditSpecialityComponent', () => {
  let component: EditSpecialityComponent;
  let fixture: ComponentFixture<EditSpecialityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSpecialityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSpecialityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
