import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarFornecedoresComponent } from './editar-fornecedores.component';

describe('EditarFornecedoresComponent', () => {
  let component: EditarFornecedoresComponent;
  let fixture: ComponentFixture<EditarFornecedoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarFornecedoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarFornecedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
