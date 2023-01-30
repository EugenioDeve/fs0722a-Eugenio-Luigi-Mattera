import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerzoComponentComponent } from './terzo-component.component';

describe('TerzoComponentComponent', () => {
  let component: TerzoComponentComponent;
  let fixture: ComponentFixture<TerzoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TerzoComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TerzoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
