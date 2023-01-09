import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimoComponentComponent } from './primo-component.component';

describe('PrimoComponentComponent', () => {
  let component: PrimoComponentComponent;
  let fixture: ComponentFixture<PrimoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrimoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
