import { Component, OnInit } from '@angular/core';
import { ResponseEntradas } from '../entrada-de-produto/shared/entrada.model';
import { EntradasService } from '../entrada-de-produto/shared/entrada.service';

@Component({
  selector: 'app-lista-entrada',
  templateUrl: './lista-entrada.component.html',
  styleUrls: ['./lista-entrada.component.css']
})
export class ListaEntradaComponent implements OnInit {
  loading: boolean;

  responseEntradas: ResponseEntradas[];

  constructor(private entradasService: EntradasService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodasEntradas();
  }

  listarTodasEntradas() {
    this.entradasService.getEntradas().subscribe(response => {
      this.responseEntradas = response;
      this.loading = false;
    });
  }
}
