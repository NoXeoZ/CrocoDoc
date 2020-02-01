import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OneStructureComponent } from './one-structure.component';

describe('OneStructureComponent', () => {
  let component: OneStructureComponent;
  let fixture: ComponentFixture<OneStructureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneStructureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneStructureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
