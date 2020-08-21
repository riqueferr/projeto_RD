import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovimentoDeLojaComponent } from './movimento-de-loja.component';

describe('MovimentoDeLojaComponent', () => {
  let component: MovimentoDeLojaComponent;
  let fixture: ComponentFixture<MovimentoDeLojaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovimentoDeLojaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovimentoDeLojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
