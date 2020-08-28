import { EntradasService } from './shared/entrada.service';
import { Entradas } from './shared/entrada.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';


import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-entrada-de-produto',
  templateUrl: './entrada-de-produto.component.html',
  styleUrls: ['../../app.component.css']
})
export class EntradaDeProdutoComponent implements OnInit {

  @ViewChild('it', { static: true }) it: NgForm;

  request: Entradas = {
    operacao: {
        cdOperacao: null,
    },
    idFilial: null,
    idFornecedor: null,
    chaveAcesso: null,
    nrNF: null,
    nrSerie: null,
    dtEmissao: null,
    dtEntrada: null,
    dtAbertura: null,
    dtFechamento: null,
    vlDocumentoFiscal: null,
    itens: [
        {
            nrItemDocumento: null,
            cdProduto: null,
            qtItem: null,
            pcIcms: null,
            vlIcms: null
        }
    ]
};

  constructor(
    private http: HttpClient,
    private entradaService: EntradasService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }


  register(): void {
    if (this.it.form.valid) {
      console.log(this.request);
      this.entradaService.createEntrada(this.request).subscribe();
      this.router.navigate(['/cupomDeVenda']);
    }
  }

}
