import { EntradasService } from './shared/entrada.service';
import { Entradas, ResponseEntradas, ResponseEntradaItens } from './shared/entrada.model';
import { ResponseProdutos } from '../lista-produtos/shared/produtos.model';
import { ProdutosService } from '../lista-produtos/shared/produtos.service';
import { ResponseFornecedores } from '../cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '../cadastro-de-fornecedor/shared/fornecedores.service';

import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';


declare var $: any;


import { NgForm, Form, FormGroup, FormControl, NgModel } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';



@Component({
  selector: 'app-entrada-de-produto',
  templateUrl: './entrada-de-produto.component.html',
  styleUrls: ['../../app.component.css']
})
export class EntradaDeProdutoComponent implements OnInit {

  loading: boolean;

  @ViewChild('it', { static: true }) it: NgForm;

  pr: any;

  request: Entradas = {
    operacao: {
      cdOperacao: 4,
    },
    idFilial: null,
    idFornecedor: null,
    chaveAcesso: 4578985,
    nrNF: 1001091,
    nrSerie: 45785985,
    emissao: null,
    entrada: null,
    vlDocumentoFiscal: null,
    itens: []
  };

  item: ResponseEntradaItens = new ResponseEntradaItens();

  teste: ResponseEntradaItens[];
  responseEntradas: ResponseEntradas[];
  responseProdutos: ResponseProdutos[];
  responseFornecedores: ResponseFornecedores[];

  constructor(
    private http: HttpClient,
    private entradaService: EntradasService,
    private responseProdutoService: ProdutosService,
    private responseFornecedoresService: FornecedoresService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosFornecedores();
    // this.listarTodosProdutos();

    $(document).ready(function () {
      $('.data').mask('00/00/0000');
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

  listarTodosProdutos() {
      console.log(this.request.idFornecedor);
      var idFornecedor = this.request.idFornecedor.toString();
      this.responseProdutoService.getProdutosFornecedores(idFornecedor).subscribe(response => {
        this.responseProdutos = response;
        this.loading = false;
      });
  }

  listarTodosFornecedores() {
    this.responseFornecedoresService.getFornecedores().subscribe(response => {
      this.responseFornecedores = response;
      this.loading = false;
    });
  }

  //Famosa gambiarra
  i: number;

  itens(): void {
    this.item.nrItemDocumento = this.i;
    this.request.itens.push(this.item);
    console.log(this.request.itens);
    this.item = new ResponseEntradaItens();
    this.i++;
  }

  pegarProdutos(produtos): void{
    console.log("Cod: " + produtos)
  }

  register(): void {
    if (this.it.form.valid) {
      console.log(this.request);
      this.entradaService.createEntrada(this.request).subscribe();
      this.router.navigate(['/listaEntradaProdutos']);
    }
  }

  validarData() {
    if (this.request.emissao != null) {
      var e = this.request.emissao.toString();
      var arrDataExclusao = e.split('/');
      var stringFormatada = arrDataExclusao[1] + '-' + arrDataExclusao[0] + '-' +
        arrDataExclusao[2];
      var dataEmissao = new Date(stringFormatada);
    }

    if (this.request.entrada != null) {
      var e = this.request.entrada.toString();
      var arrDataExclusao = e.split('/');
      var stringFormatada = arrDataExclusao[1] + '-' + arrDataExclusao[0] + '-' +
        arrDataExclusao[2];
      var dataEntrada = new Date(stringFormatada);
    }

    if (dataEmissao > dataEntrada) {
      return false;
    } else {
      return true;
    }
  }

}
