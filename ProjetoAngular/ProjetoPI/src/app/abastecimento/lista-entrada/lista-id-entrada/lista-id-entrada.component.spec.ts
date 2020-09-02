import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaIdEntradaComponent } from './lista-id-entrada.component';

describe('ListaIdEntradaComponent', () => {
  let component: ListaIdEntradaComponent;
  let fixture: ComponentFixture<ListaIdEntradaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaIdEntradaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaIdEntradaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
