import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaTransferenciaComponent } from './lista-transferencia.component';

describe('ListaTransferenciaComponent', () => {
  let component: ListaTransferenciaComponent;
  let fixture: ComponentFixture<ListaTransferenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaTransferenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaTransferenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
