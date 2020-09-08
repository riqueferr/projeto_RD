import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaNmfilialEntradaComponent } from './lista-nmfilial-entrada.component';

describe('ListaNmfilialEntradaComponent', () => {
  let component: ListaNmfilialEntradaComponent;
  let fixture: ComponentFixture<ListaNmfilialEntradaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaNmfilialEntradaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaNmfilialEntradaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
