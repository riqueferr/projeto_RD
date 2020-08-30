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

  // private readonly API2 = 'http://localhost:8080/abastecimento/FilialEstoque/2';

  getEstoques() {
    return this.http.get<ResponseEstoque[]>(this.API);
  }

  // getEstoques3() {
  //   return this.http.get<ResponseEstoque[]>(this.API2);
  // }

  
  getEstoque(codigo: string): Observable<ResponseEstoque> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseEstoque>(URL);
  }

}
