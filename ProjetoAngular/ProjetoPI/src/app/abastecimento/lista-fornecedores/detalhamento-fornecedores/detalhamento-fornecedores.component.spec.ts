import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhamentoFornecedoresComponent } from './detalhamento-fornecedores.component';

describe('DetalhamentoFornecedoresComponent', () => {
  let component: DetalhamentoFornecedoresComponent;
  let fixture: ComponentFixture<DetalhamentoFornecedoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalhamentoFornecedoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalhamentoFornecedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
