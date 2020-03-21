import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUserRegularComponent } from './update-user-regular.component';

describe('UpdateUserRegularComponent', () => {
  let component: UpdateUserRegularComponent;
  let fixture: ComponentFixture<UpdateUserRegularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateUserRegularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateUserRegularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
