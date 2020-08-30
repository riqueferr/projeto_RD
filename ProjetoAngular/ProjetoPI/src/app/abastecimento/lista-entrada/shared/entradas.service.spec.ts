import { TestBed } from '@angular/core/testing';

import { EntradasService } from './listEntrada.service';

describe('ProdutosService', () => {
  let service: EntradasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EntradasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
