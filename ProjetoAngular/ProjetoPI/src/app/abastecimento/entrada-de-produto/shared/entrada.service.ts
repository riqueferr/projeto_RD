import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entradas, ResponseEntradas, Produto } from './entrada.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntradasService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/entrada';

  private readonly APIFilial = 'http://localhost:8080/abastecimento/entrada/filial';

  private readonly APIProduto = 'http://localhost:8080/abastecimento/produtos';

  getEntradas() {
    return this.http.get<ResponseEntradas[]>(this.API);
  }

  getEntrada(codigo: string): Observable<ResponseEntradas> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseEntradas>(URL);
  }

  getFilial(codigo: string): Observable<ResponseEntradas> {
    const URL = `${this.APIFilial}/${codigo}`;
    return this.http.get<ResponseEntradas>(URL);
  }

  updateEntrada(codigo: string, request: Entradas): Observable<Entradas> {
    const URL = `${this.API}`;
    return this.http.put<Entradas>(URL, request);
  }

  createEntrada(request: Entradas): Observable<Entradas> {
    const URL = `${this.API}`;
    return this.http.post<Entradas>(URL, request);
  }

  getProduto(codigo: number): Observable<Produto>{
    const URL = `${this.APIProduto}/${codigo}`;
    return this.http.get<Produto>(URL);
  }

}
