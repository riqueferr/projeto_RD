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
  private readonly APINomeProduto = 'http://localhost:8080/abastecimento/relatorioproduto/nmproduto';
  private readonly APIStatusProduto = 'http://localhost:8080/abastecimento/relatorioproduto/status';

  getRelatorioEstoque() {
    return this.http.get<ResponseRelatorioProduto[]>(this.API);
  }

  getRelatorioProdutoPorNome(codigo: string): Observable<ResponseRelatorioProduto> {
    const URL = `${this.APINomeProduto}/${codigo}`;
    return this.http.get<ResponseRelatorioProduto>(URL);
  }

  getRelatorioProdutoPorStatus(codigo: string): Observable<ResponseRelatorioProduto> {
    const URL = `${this.APIStatusProduto}/${codigo}`;
    return this.http.get<ResponseRelatorioProduto>(URL);
  }

}
