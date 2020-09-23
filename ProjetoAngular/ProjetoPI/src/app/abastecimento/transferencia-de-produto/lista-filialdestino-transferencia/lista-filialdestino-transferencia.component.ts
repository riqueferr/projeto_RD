import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TransferenciaService } from '../shared/transferencia.service';
import { ResponseTransferencia } from '../shared/transferencia.model';

@Component({
  selector: 'app-lista-filialdestino-transferencia',
  templateUrl: './lista-filialdestino-transferencia.component.html',
  styleUrls: ['./lista-filialdestino-transferencia.component.css']
})
export class ListaFilialdestinoTransferenciaComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;
  idDF: any;
  nmFilialDestino: any;
  request: any;

  // Configuração da ordenação
  key: string = 'idDocumento';
  reverse: boolean = false;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

  responseTransferencia: ResponseTransferencia[];

  constructor(
    private responseService: TransferenciaService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorNmFilialDestino();
  }

  listarPorNmFilialDestino(): void {
    this.nmFilialDestino = this.route.snapshot.paramMap.get('nmFilialDestino');
    this.responseService.getPesquisaFilialTransferencia(this.nmFilialDestino).subscribe(response => {
      this.request = response;
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
