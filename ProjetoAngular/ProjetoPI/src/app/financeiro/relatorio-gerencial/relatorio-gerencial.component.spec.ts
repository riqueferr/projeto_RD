import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatorioGerencialComponent } from './relatorio-gerencial.component';

describe('RelatorioGerencialComponent', () => {
  let component: RelatorioGerencialComponent;
  let fixture: ComponentFixture<RelatorioGerencialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RelatorioGerencialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RelatorioGerencialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
