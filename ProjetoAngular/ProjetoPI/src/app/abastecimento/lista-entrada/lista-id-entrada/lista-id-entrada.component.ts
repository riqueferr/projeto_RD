import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { ResponseEntradas, ResponseEntradaItens } from '../../entrada-de-produto/shared/entrada.model';
import { EntradasService } from '../../entrada-de-produto/shared/entrada.service';

@Component({
  selector: 'app-lista-id-entrada',
  templateUrl: './lista-id-entrada.component.html',
  styleUrls: ['./lista-id-entrada.component.css']
})
export class ListaIdEntradaComponent implements OnInit {

  @ViewChild('it', { static: true }) formDF: NgForm;

  loading: boolean;

  idDF: any;
  request: any;
  responseEntradas: ResponseEntradas[];

  responseItens: ResponseEntradaItens[];

  constructor(
    private entradasService: EntradasService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

    ngOnInit(): void {
      this.idDF = this.route.snapshot.paramMap.get('idDF');
      this.entradasService.getEntrada(this.idDF).subscribe(response => this.request = response);
    }

    register(): void {
      console.log(this.idDF);
      this.entradasService.getEntrada(this.idDF).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaEntradaProdutos', this.idDF]));
    }


}
