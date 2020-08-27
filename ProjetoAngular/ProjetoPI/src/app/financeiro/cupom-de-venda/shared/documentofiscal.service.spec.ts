import { TestBed } from '@angular/core/testing';

import { DocumentoFiscalService } from './documentofiscal.service';

describe('ProdutosService', () => {
  let service: DocumentoFiscalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocumentoFiscalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
