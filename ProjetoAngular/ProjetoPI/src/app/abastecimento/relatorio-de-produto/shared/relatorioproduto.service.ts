import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto, ResponseRelatorioProduto } from './relatorioproduto.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RelatorioProdutoService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/relatorioproduto';

  getRelatorioEstoque() {
    return this.http.get<ResponseRelatorioProduto[]>(this.API);
  }

}
