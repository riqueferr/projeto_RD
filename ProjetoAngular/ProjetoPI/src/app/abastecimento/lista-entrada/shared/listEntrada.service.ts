import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entradas, ResponseEntrada } from './listEntrada.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntradasService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/entrada';

  getProdutos() {
    return this.http.get<ResponseEntrada[]>(this.API);
  }

  getProduto(codigo: string): Observable<ResponseEntrada> {
    const URL = `${this.API}/${codigo}`;
    return this.http.get<ResponseEntrada>(URL);
  }

}
