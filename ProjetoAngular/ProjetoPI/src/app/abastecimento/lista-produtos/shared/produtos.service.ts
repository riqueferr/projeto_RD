import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produtos, ResponseProdutos } from './produtos.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/produtos';

  getProdutos() {
    return this.http.get<ResponseProdutos[]>(this.API);
  }

}
