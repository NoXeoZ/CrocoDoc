import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DmpSecretaryComponent } from './dmp-secretary.component';

describe('DmpAdminComponent', () => {
  let component: DmpSecretaryComponent;
  let fixture: ComponentFixture<DmpSecretaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DmpSecretaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DmpSecretaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
