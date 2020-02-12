import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DmpAdminEditComponent } from './dmp-admin-edit.component';

describe('DmpAdminEditComponent', () => {
  let component: DmpAdminEditComponent;
  let fixture: ComponentFixture<DmpAdminEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DmpAdminEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DmpAdminEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
