import { Component, OnInit } from '@angular/core';
import { ResponseTransferencia } from '../shared/transferencia.model';
import { TransferenciaService } from '../shared/transferencia.service';

@Component({
  selector: 'app-lista-transferencia',
  templateUrl: './lista-transferencia.component.html',
  styleUrls: ['./lista-transferencia.component.css']
})
export class ListaTransferenciaComponent implements OnInit {

  loading: boolean;

  responseTransferencia: ResponseTransferencia[];

  constructor(private responseService: TransferenciaService) { }

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
