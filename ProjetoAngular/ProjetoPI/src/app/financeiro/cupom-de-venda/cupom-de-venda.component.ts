import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { ResponseDF } from './shared/documentofiscal.model';
import { DocumentoFiscalService } from './shared/documentofiscal.service';

@Component({
  selector: 'app-cupom-de-venda',
  templateUrl: './cupom-de-venda.component.html',
  styleUrls: ['../../app.component.css']
})
export class CupomDeVendaComponent implements OnInit {

  loading : boolean;
  idDF: any;
  
  public paginaAtual = 1;

  // Configuração da ordenação
  key: string = 'idDocumento';
  reverse: boolean = false;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

  responseDf: ResponseDF[];

  constructor(
    private dfService: DocumentoFiscalService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosDF();
  }
  
  listarTodosDF() {
    this.dfService.getDocumentoFiscal().subscribe(response => {
        this.responseDf = response;
        this.loading = false;
      });
  }

  register(): void {
    if (this.idDF != null) {
      console.log(this.idDF);
      this.dfService.getDF(this.idDF).subscribe();
      this.router.navigate(['/detalhamentoCupomDeVendas', this.idDF]);
    }
  }

}
