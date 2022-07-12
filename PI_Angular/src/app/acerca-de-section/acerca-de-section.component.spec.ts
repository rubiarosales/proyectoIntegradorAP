import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaDeSectionComponent } from './acerca-de-section.component';

describe('AcercaDeSectionComponent', () => {
  let component: AcercaDeSectionComponent;
  let fixture: ComponentFixture<AcercaDeSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaDeSectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcercaDeSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
