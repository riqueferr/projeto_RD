import { TransferenciaService } from './shared/transferencia.service';
import { Transferencia, ResponseFiliais } from './shared/transferencia.model';
import { ResponseProdutos} from '../lista-produtos/shared/produtos.model';
import { ProdutosService } from '../lista-produtos/shared/produtos.service';
import { EstoqueService } from '../relatorio-de-estoque/shared/estoque.service';
import { ResponseEstoque } from '../relatorio-de-estoque/shared/estoque.model';
import { ResponseEntradaItens } from '../entrada-de-produto/shared/entrada.model';
import { FornecedoresService } from '../cadastro-de-fornecedor/shared/fornecedores.service';
import { ResponseFornecedores } from '../cadastro-de-fornecedor/shared/fornecedores.model';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';

declare var $: any;

@Component({
  selector: 'app-transferencia-de-produto',
  templateUrl: './transferencia-de-produto.component.html',
  styleUrls: ['./transferencia-de-produto.component.css']
})
export class TransferenciaDeProdutoComponent implements OnInit {

  loading: boolean;

  responseProdutos: ResponseProdutos[];
  responseEstoque: ResponseEstoque[];
  responseFiliais: ResponseFiliais[];
  item: ResponseEntradaItens = new ResponseEntradaItens();

  @ViewChild('it', { static: true }) it: NgForm;

  request: Transferencia = {
    operacao: {
        cdOperacao: 2,
    },
      idFilial: null,
      idFilialDestino: null,
      chaveAcesso: 5679,
      nrNF: 410,
      nrSerie: 4444444,
      emissao: null,
      entrada: null,
      vlDocumentoFiscal: null,
      itens: []
    };

  constructor(
    private http: HttpClient,
    private router: Router,
    private transferenciaService: TransferenciaService,
    private responseProdutoService: ProdutosService,
  ) { }

  ngOnInit(): void {
    this.loading = true;
    // this.listarTodosProdutos();
    this.listarTodasFiliais();

    $(document).ready(function() {
      // alert('Eu estou usando JQuery');
      $('.data').mask('00/00/0000');

    });
    this.i = 1;
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  // listarTodosProdutos() {
  //   this.responseProdutoService.getProdutos().subscribe(response => {
  //     this.responseProdutos = response;
  //     this.loading = false;
  //   });
  // }

  listarTodosProdutos() {
    console.log(this.request.idFilial);
    var idFilial = this.request.idFilial.toString();
    this.transferenciaService.getFilialProduto(idFilial).subscribe(response => {
      this.responseEstoque = response;
      this.loading = false;
    });
  }

   //Famosa gambiarra
   i: number;
  
   itens(): void{
     this.item.nrItemDocumento = this.i;
     this.request.itens.push(this.item);
     console.log(this.request.itens);
     this.item = new ResponseEntradaItens();
     this.i ++;
   }

   pegar(){
      console.log(this.request.itens);
   }

  listarTodasFiliais() {
    this.transferenciaService.getFiliais().subscribe(response => {
      this.responseFiliais = response;
      this.loading = false;
    });
  }

  register(): void {
    if (this.it.form.valid) {
      console.log(this.request);
      this.transferenciaService.createTransferencia(this.request).subscribe();
      this.router.navigate(['/listaTransferenciaProduto']);
      alert("Transferência registrada com sucesso!");
    }
  }

  validarDataEmissao(){
    if (this.request.emissao != null) {
      var e = this.request.emissao.toString();
      var arrDataExclusao = e.split('/');
      var stringFormatada = arrDataExclusao[1] + '-' + arrDataExclusao[0] + '-' +
        arrDataExclusao[2];
      var dataEmissao = new Date(stringFormatada);
    }

    let dataAtual = new Date();

    if(dataEmissao > dataAtual){
      return false;
    }else{
      return true;
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
