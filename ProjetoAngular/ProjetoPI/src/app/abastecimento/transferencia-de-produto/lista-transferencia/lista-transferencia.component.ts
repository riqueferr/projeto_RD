import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { ResponseTransferencia, ResponseFiliais } from '../shared/transferencia.model';
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
  idDF: any;
  nmFilialDestino: any;

  responseTransferencia: ResponseTransferencia[];
  responseFiliais: ResponseFiliais[];

    // Configuração da ordenação
    key: string = 'idDocumento';
    reverse: boolean = false;
    sort(key) {
        this.key = key;
        this.reverse = !this.reverse;
    }

  constructor(
    private responseService: TransferenciaService,
    private router: Router
    ) { }

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

  listarTodasFiliais() {
    this.responseService.getFiliais().subscribe(response => {
      this.responseFiliais = response;
      this.loading = false;
    });
  }

  register(): void {
    if (this.idDF != null && this.idDF > 0) {
      console.log(this.idDF);
      this.responseService.getTransferencia(this.idDF).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaTransferenciaProduto', this.idDF]));
    }
    else {
      console.log(this.nmFilialDestino);
      this.responseService.getPesquisaFilialTransferencia(this.nmFilialDestino).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaTransferenciaProduto/filial', this.nmFilialDestino]));
    }
  }


}
