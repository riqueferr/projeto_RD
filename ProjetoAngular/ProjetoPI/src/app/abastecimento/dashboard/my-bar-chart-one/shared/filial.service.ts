import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResponseFiliais } from './filial.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilialService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost:8080/abastecimento/filial/produtos/lista';

  getBuscarQuantidadeProdutosPorLoja() {
    return this.http.get<ResponseFiliais>(this.API);
  }

}
