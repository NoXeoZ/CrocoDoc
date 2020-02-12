import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DmpAdminComponent } from './dmp-admin.component';

describe('DmpAdminComponent', () => {
  let component: DmpAdminComponent;
  let fixture: ComponentFixture<DmpAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DmpAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DmpAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
