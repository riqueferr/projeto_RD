import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

import { Entradas, ResponseEntradas, ResponseEntradaItens } from '../entrada-de-produto/shared/entrada.model';
import { EntradasService } from '../entrada-de-produto/shared/entrada.service';
import { Itens } from 'src/app/financeiro/cupom-de-venda/shared/documentofiscal.model';
import { AlertModalComponent } from '../shared/alert-modal/alert-modal.component';
import { AlertModalService } from '../shared/alert-modal.service';

@Component({
  selector: 'app-lista-entrada',
  templateUrl: './lista-entrada.component.html',
  styleUrls: ['./lista-entrada.component.css']
})
export class ListaEntradaComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;
  

  responseEntradas: ResponseEntradas[];
  item: ResponseEntradaItens[];

  idDF: any;
  nmFilial: any;

  // Configuração da ordenação
  key: string = 'idDocumento';
  reverse: boolean = false;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

  constructor(
    private entradasService: EntradasService,
    private http: HttpClient,
    private router: Router,
    private alertService: AlertModalService
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodasEntradas();
    this.item;
  }

  listarTodasEntradas() {
    this.entradasService.getEntradas().subscribe(response => {
      this.responseEntradas = response;
      this.loading = false;
    });
  }

  register(): void {
    if (this.idDF != null) {
      console.log(this.idDF);
      this.entradasService.getEntrada(this.idDF).subscribe();
      this.router.navigate(['/listaEntradaProdutos', this.idDF]);
    } else {
      console.log(this.nmFilial);
      this.entradasService.getFilial(this.nmFilial).subscribe();
      this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]);
    }
  }

  handleError(){
    this.alertService.showAlertDanger('Erro ao carregar lista de entradas!');
  }

}
