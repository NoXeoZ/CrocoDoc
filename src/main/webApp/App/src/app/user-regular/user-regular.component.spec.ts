import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegularComponent } from './user-regular.component';

describe('UserRegularComponent', () => {
  let component: UserRegularComponent;
  let fixture: ComponentFixture<UserRegularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRegularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRegularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
