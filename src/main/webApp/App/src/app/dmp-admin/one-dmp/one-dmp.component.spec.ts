import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneDmpComponent } from './one-dmp.component';

describe('OneDmpComponent', () => {
  let component: OneDmpComponent;
  let fixture: ComponentFixture<OneDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
