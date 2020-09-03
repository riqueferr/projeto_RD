import { EntradasService } from './shared/entrada.service';
import { Entradas, ResponseEntradas, ResponseEntradaItens } from './shared/entrada.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';


declare var $: any;


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
        cdOperacao: 4,
    },
    idFilial: null,
    idFornecedor: null,
    chaveAcesso: 4578985,
    nrNF: 1001091,
    nrSerie: 45785985,
    dtEmissao: null,
    dtEntrada: null,
    vlDocumentoFiscal: null,
    itens: [
    ]
  };

  item: ResponseEntradaItens = new ResponseEntradaItens();

  responseEntradas: ResponseEntradas[];

  constructor(
    private http: HttpClient,
    private entradaService: EntradasService,
    private router: Router
  ) { }

  ngOnInit(): void {

    


    $(document).ready(function() {
      // alert('Eu estou usando JQuery');

      $('.telefone').mask('(00) 0 0000-0000');
      $('.data').mask('00/00/0000');
      $(".dinheiro").mask('000.000.000.000,000.00', {reverse: true});

      $(".dinheiro").change(function(){
        $("#value").html($(this).val().replace(/\D/g,''))
      })



    });
    this.i = 1;
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }



  listarTodasEntradas() {
    this.entradaService.getEntradas().subscribe(response => {
      this.responseEntradas = response;
    });
  }

  //Famosa gambiarra
  i: number;
  
  itens(): void{
    this.item.nrItemDocumento = this.i;
    this.request.itens.push(this.item);
    this.item = new ResponseEntradaItens();
    this.i ++;
  }


  register(): void {
    if (this.it.form.valid) {
      console.log(this.request);
      this.entradaService.createEntrada(this.request).subscribe();
      this.router.navigate(['/listaEntradaProdutos']);
    }
  }

  

}
