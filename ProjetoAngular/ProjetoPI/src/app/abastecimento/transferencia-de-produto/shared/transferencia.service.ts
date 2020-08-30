import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transferencia, ResponseTransferencia } from './transferencia.model';
import { Observable } from 'rxjs';
import { ResponseProdutos } from '../../lista-produtos/shared/produtos.model';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/transferencia';

  // private readonly APIProdutos = 'http://localhost:8080/abastecimento/produtos';

  getTransferencias() {
    return this.http.get<ResponseTransferencia[]>(this.API);
  }

  // getTransferencia(codigo: string): Observable<ResponseTransferencia> {
  //   const URL = `${this.API}/${codigo}`;
  //   return this.http.get<ResponseTransferencia>(URL);
  // }

  updateTransferencia(codigo: string, request: Transferencia): Observable<Transferencia> {
    const URL = `${this.API}`;
    return this.http.put<Transferencia>(URL, request);
  }

  createTransferencia(request: Transferencia): Observable<Transferencia> {
    const URL = `${this.API}`;
    return this.http.post<Transferencia>(URL, request);
  }

}
