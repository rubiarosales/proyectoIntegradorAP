import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaEduComponent } from './nueva-edu.component';

describe('NuevaEduComponent', () => {
  let component: NuevaEduComponent;
  let fixture: ComponentFixture<NuevaEduComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevaEduComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevaEduComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
