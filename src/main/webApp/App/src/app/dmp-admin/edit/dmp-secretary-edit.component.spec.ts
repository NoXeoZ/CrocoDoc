import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DmpSecretaryEditComponent } from './dmp-secretary-edit.component';

describe('DmpAdminEditComponent', () => {
  let component: DmpSecretaryEditComponent;
  let fixture: ComponentFixture<DmpSecretaryEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DmpSecretaryEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DmpSecretaryEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
