import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { ResponseDF } from '../cupom-de-venda/shared/documentofiscal.model';
import { DocumentoFiscalService } from '../cupom-de-venda/shared/documentofiscal.service';

@Component({
  selector: 'app-detalhamento-cupom-de-vendas',
  templateUrl: './detalhamento-cupom-de-vendas.component.html',
  styleUrls: ['./detalhamento-cupom-de-vendas.component.css']
})
export class DetalhamentoCupomDeVendasComponent implements OnInit {

  @ViewChild('formDF', { static: true }) formDF: NgForm;

  loading: boolean;

  idDF: any;
  request: any;
  
  responseDf: ResponseDF[];

  constructor(
    private documentoFiscalService: DocumentoFiscalService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.idDF = this.route.snapshot.paramMap.get('idDF');
    this.documentoFiscalService.getDF(this.idDF).subscribe(response => {
      this.request = response;
      this.loading = false;
    });
  }

}
