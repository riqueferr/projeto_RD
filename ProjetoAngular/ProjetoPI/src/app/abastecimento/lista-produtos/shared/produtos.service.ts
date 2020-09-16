import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produtos, ResponseProdutos, ResponseSubCategorias, ResponseStatus, ResponseTipoProduto } from './produtos.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/produtos';
  private readonly APISubCategoria = 'http://localhost:8080/abastecimento/subcategorias';
  private readonly ApiStatus = 'http://localhost:8080/abastecimento/status';
  private readonly ApiTipoProduto = 'http://localhost:8080/abastecimento/tipoproduto';
  private readonly ApiFornecedores = 'http://localhost:8080/abastecimento/produtos/fornecedor';
  // private readonly APIFilialProduto = 'http://localhost:8080/abastecimento/FilialEstoque/filialproduto'

  getProdutos() {
    return this.http.get<ResponseProdutos[]>(this.API);
  }

  getSubCategoria() {
    return this.http.get<ResponseSubCategorias[]>(this.APISubCategoria);
  }

  getStatus() {
    return this.http.get<ResponseStatus[]>(this.ApiStatus);
  }

  getTipoProduto() {
    return this.http.get<ResponseTipoProduto[]>(this.ApiTipoProduto);
  }

  getProdutosFornecedores(codigo: string): Observable<ResponseProdutos[]> {
    const URL = `${this.ApiFornecedores}/${codigo}`;
    return this.http.get<ResponseProdutos[]>(URL);
  }

  // getFilialProduto(codigo: string): Observable<ResponseProdutos[]> {
  //   const URL = `${this.APIFilialProduto}/${codigo}`;
  //   return this.http.get<ResponseProdutos[]>(URL);
  // }

  getProduto(codigo: string): Observable<ResponseProdutos> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseProdutos>(URL);
  }

  updateProduto(codigo: string, request: Produtos): Observable<Produtos> {
    const URL = `${this.API}`;
    return this.http.put<Produtos>(URL, request);
  }

  createProduto(request: Produtos): Observable<Produtos> {
    return this.http.post<Produtos>(this.API, request);
  }
}
