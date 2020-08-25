import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaFornecedoresComponent } from './lista-fornecedores.component';

describe('ListaFornecedoresComponent', () => {
  let component: ListaFornecedoresComponent;
  let fixture: ComponentFixture<ListaFornecedoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaFornecedoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaFornecedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
