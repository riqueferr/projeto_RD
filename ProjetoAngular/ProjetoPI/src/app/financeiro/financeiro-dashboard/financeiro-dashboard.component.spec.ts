import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceiroDashboardComponent } from './financeiro-dashboard.component';

describe('FinanceiroDashboardComponent', () => {
  let component: FinanceiroDashboardComponent;
  let fixture: ComponentFixture<FinanceiroDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceiroDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceiroDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
