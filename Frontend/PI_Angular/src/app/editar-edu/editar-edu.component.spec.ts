import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarEduComponent } from './editar-edu.component';

describe('EditarEduComponent', () => {
  let component: EditarEduComponent;
  let fixture: ComponentFixture<EditarEduComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarEduComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarEduComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
