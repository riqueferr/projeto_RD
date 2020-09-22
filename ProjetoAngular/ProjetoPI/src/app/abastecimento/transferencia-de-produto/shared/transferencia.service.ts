import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transferencia, ResponseTransferencia, ResponseFiliais, Produto } from './transferencia.model';
import { Observable } from 'rxjs';
import { ResponseProdutos } from '../../lista-produtos/shared/produtos.model';
import { ResponseEstoque } from '../../relatorio-de-estoque/shared/estoque.model';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/transferencia';
  private readonly APIFilial = 'http://localhost:8080/abastecimento/filial';
  private readonly APINomeFilial = 'http://localhost:8080/abastecimento/transferencia/filial'
  private readonly APILojas = 'http://localhost:8080/abastecimento/filial/cd/RD'
  private readonly APIFilialProduto = 'http://localhost:8080/abastecimento/FilialEstoque/filialproduto'
  private readonly APIProduto = 'http://localhost:8080/abastecimento/produtos';


  getFilialProduto(codigo: string): Observable<ResponseEstoque[]> {
    const URL = `${this.APIFilialProduto}/${codigo}`;
    return this.http.get<ResponseEstoque[]>(URL);
  }

  getTransferencias() {
    return this.http.get<ResponseTransferencia[]>(this.API);
  }

  getFiliais() {
    return this.http.get<ResponseFiliais[]>(this.APILojas);
  }

  getTransferencia(codigo: string): Observable<ResponseTransferencia> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseTransferencia>(URL);
  }

  getPesquisaFilialTransferencia(codigo: string): Observable<ResponseTransferencia> {
    const URL = `${this.APINomeFilial}/${codigo}`;
    return this.http.get<ResponseTransferencia>(URL);
  }

  updateTransferencia(codigo: string, request: Transferencia): Observable<Transferencia> {
    const URL = `${this.API}`;
    return this.http.put<Transferencia>(URL, request);
  }

  createTransferencia(request: Transferencia): Observable<Transferencia> {
    const URL = `${this.API}`;
    return this.http.post<Transferencia>(URL, request);
  }

  getProduto(codigo: number): Observable<Produto>{
    const URL = `${this.APIProduto}/${codigo}`;
    return this.http.get<Produto>(URL);
  }

}
