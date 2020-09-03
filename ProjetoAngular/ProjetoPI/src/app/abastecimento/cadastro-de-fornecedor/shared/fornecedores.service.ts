import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Fornecedores, ResponseFornecedores } from './fornecedores.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FornecedoresService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/fornecedores';

  private readonly API2 = 'http://localhost:8080/abastecimento/fornecedores/page';

  getFornecedores() {
    return this.http.get<ResponseFornecedores[]>(this.API);
  }

  getFornecedor(codigo: string): Observable<ResponseFornecedores> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseFornecedores>(URL);
  }

  getFornecedorPage(codigo: string): Observable<ResponseFornecedores> {
    const URL = `${this.API2}/${codigo}`;
    return this.http.get<ResponseFornecedores>(URL);
  }

  updateFornecedor(codigo: string, request: Fornecedores): Observable<Fornecedores> {
    const URL = `${this.API}`;
    return this.http.put<Fornecedores>(URL, request);
  }

  createFornecedor(request: Fornecedores): Observable<Fornecedores> {
    const URL = `${this.API}`;
    return this.http.post<Fornecedores>(URL, request);
  }

}
