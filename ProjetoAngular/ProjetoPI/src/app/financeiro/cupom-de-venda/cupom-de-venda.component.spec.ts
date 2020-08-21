import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CupomDeVendaComponent } from './cupom-de-venda.component';

describe('CupomDeVendaComponent', () => {
  let component: CupomDeVendaComponent;
  let fixture: ComponentFixture<CupomDeVendaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CupomDeVendaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CupomDeVendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
