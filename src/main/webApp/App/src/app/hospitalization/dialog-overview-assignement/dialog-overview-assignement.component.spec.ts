import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogOverviewAssignementComponent } from './dialog-overview-assignement.component';

describe('DialogOverviewAssignementComponent', () => {
  let component: DialogOverviewAssignementComponent;
  let fixture: ComponentFixture<DialogOverviewAssignementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogOverviewAssignementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogOverviewAssignementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
