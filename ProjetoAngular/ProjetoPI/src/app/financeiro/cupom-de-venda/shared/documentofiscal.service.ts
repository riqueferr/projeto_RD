import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Nota, ResponseDF } from './documentofiscal.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentoFiscalService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/documentofiscal';

  getDocumentoFiscal() {
    return this.http.get<ResponseDF[]>(this.API);
  }

  getDF(idDF: string): Observable<ResponseDF> {
    const URL = `${this.API}/${idDF}`;
    return this.http.get<ResponseDF>(URL);
  }

}
