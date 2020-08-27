import { Component, OnInit } from '@angular/core';
import { ResponseDF } from './shared/documentofiscal.model';
import { DocumentoFiscalService } from './shared/documentofiscal.service';

@Component({
  selector: 'app-cupom-de-venda',
  templateUrl: './cupom-de-venda.component.html',
  styleUrls: ['../../app.component.css']
})
export class CupomDeVendaComponent implements OnInit {

  loading : boolean;

  responseDf: ResponseDF[];

  constructor(private dfService: DocumentoFiscalService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosDF();
  }

  
  listarTodosDF() {
    this.dfService.getDocumentoFiscal().subscribe(response => 
      {
        this.responseDf = response;
        this.loading = false;
      });
  }

}
