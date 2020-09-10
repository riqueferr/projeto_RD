import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produtos, ResponseEstoque } from './estoque.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstoqueService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/FilialEstoque';
  private readonly APIFilial = 'http://localhost:8080/abastecimento/FilialEstoque/filial';
  private readonly APINomeFilial = 'http://localhost:8080/abastecimento/FilialEstoque/filial/nome/';

  getEstoques() {
    return this.http.get<ResponseEstoque[]>(this.API);
  }

  getEstoqueFilial(codigo: string): Observable<ResponseEstoque> {
    const URL = `${this.APIFilial}/${codigo}`;
    return this.http.get<ResponseEstoque>(URL);
  }

  getEstoqueNomeFilial(codigo: string): Observable<ResponseEstoque> {
    const URL = `${this.APINomeFilial}/${codigo}`;
    return this.http.get<ResponseEstoque>(URL);
  }
  
  getEstoque(codigo: string): Observable<ResponseEstoque> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseEstoque>(URL);
  }

}
