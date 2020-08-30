import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaEntradaComponent } from './lista-entrada.component';

describe('ListaEntradaComponent', () => {
  let component: ListaEntradaComponent;
  let fixture: ComponentFixture<ListaEntradaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaEntradaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaEntradaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
