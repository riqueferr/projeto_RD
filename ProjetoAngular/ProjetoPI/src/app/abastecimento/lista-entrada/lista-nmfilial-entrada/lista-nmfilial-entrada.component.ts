import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { ResponseEntradas, ResponseEntradaItens } from '../../entrada-de-produto/shared/entrada.model';
import { EntradasService } from '../../entrada-de-produto/shared/entrada.service';

@Component({
  selector: 'app-lista-nmfilial-entrada',
  templateUrl: './lista-nmfilial-entrada.component.html',
  styleUrls: ['./lista-nmfilial-entrada.component.css']
})
export class ListaNmfilialEntradaComponent implements OnInit {

  @ViewChild('it', { static: true }) formDF: NgForm;

  loading: boolean;

  idDF: any;
  nmFilial: any;
  request: any;

  public paginaAtual = 1;

    // Configuração da ordenação
    key: string = 'idDocumento';
    reverse: boolean = false;
    sort(key) {
        this.key = key;
        this.reverse = !this.reverse;
    }

  responseEntradas: ResponseEntradas[];
  responseItens: ResponseEntradaItens[];

  constructor(
    private entradasService: EntradasService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorNmFilial();
  }

  listarPorNmFilial(): void {
    this.nmFilial = this.route.snapshot.paramMap.get('nmFilial');
    this.entradasService.getFilial(this.nmFilial).subscribe(response => {
      this.request = response;
      this.loading = false;
    });
  }

  register(): void {
    if (this.idDF != null && this.idDF > 0) {
      console.log(this.idDF);
      this.entradasService.getEntrada(this.idDF).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaEntradaProdutos', this.idDF]));
    } else {
      console.log(this.nmFilial);
      this.entradasService.getFilial(this.nmFilial).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]));
    }
  }

}
