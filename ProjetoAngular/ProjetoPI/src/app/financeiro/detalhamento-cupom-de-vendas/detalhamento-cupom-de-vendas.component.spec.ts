import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhamentoCupomDeVendasComponent } from './detalhamento-cupom-de-vendas.component';

describe('DetalhamentoCupomDeVendasComponent', () => {
  let component: DetalhamentoCupomDeVendasComponent;
  let fixture: ComponentFixture<DetalhamentoCupomDeVendasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalhamentoCupomDeVendasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalhamentoCupomDeVendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
