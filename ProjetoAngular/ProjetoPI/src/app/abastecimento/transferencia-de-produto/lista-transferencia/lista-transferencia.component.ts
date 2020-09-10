import { Component, OnInit } from '@angular/core';
import { ResponseTransferencia } from '../shared/transferencia.model';
import { TransferenciaService } from '../shared/transferencia.service';
import { ResponseProdutos } from '../../lista-produtos/shared/produtos.model';
import { ProdutosService } from '../../lista-produtos/shared/produtos.service';

@Component({
  selector: 'app-lista-transferencia',
  templateUrl: './lista-transferencia.component.html',
  styleUrls: ['./lista-transferencia.component.css']
})
export class ListaTransferenciaComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;

  responseTransferencia: ResponseTransferencia[];

  constructor(
    private responseService: TransferenciaService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodasTransferencias();
  }

  listarTodasTransferencias() {
    this.responseService.getTransferencias().subscribe(response => {
      this.responseTransferencia = response;
      this.loading = false;
    });
  }


}
