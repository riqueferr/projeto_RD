import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPageFornecedoresComponent } from './listar-page-fornecedores.component';

describe('ListarPageFornecedoresComponent', () => {
  let component: ListarPageFornecedoresComponent;
  let fixture: ComponentFixture<ListarPageFornecedoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarPageFornecedoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPageFornecedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
