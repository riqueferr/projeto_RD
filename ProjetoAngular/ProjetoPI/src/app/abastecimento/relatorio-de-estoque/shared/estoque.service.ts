import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Filial, ResponseEstoque } from './estoque.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstoqueService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/relatorioestoque';

  getEstoques() {
    return this.http.get<ResponseEstoque[]>(this.API);
  }

}
