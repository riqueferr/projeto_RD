import { TransferenciaService } from './shared/transferencia.service';
import { Transferencia, ResponseFiliais } from './shared/transferencia.model';
import { ResponseProdutos} from '../lista-produtos/shared/produtos.model';
import { ProdutosService } from '../lista-produtos/shared/produtos.service';
import { EstoqueService } from '../relatorio-de-estoque/shared/estoque.service';
import { ResponseEstoque } from '../relatorio-de-estoque/shared/estoque.model';
import { Produto, ResponseEntradaItens } from '../entrada-de-produto/shared/entrada.model';
import { FornecedoresService } from '../cadastro-de-fornecedor/shared/fornecedores.service';
import { ResponseFornecedores } from '../cadastro-de-fornecedor/shared/fornecedores.model';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';
import { AlertModalService } from '../shared/alert-modal.service';

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
  responseProduto: Produto;

  @ViewChild('it', { static: true }) it: NgForm;
  @ViewChild('itItens', { static: true }) itItens: NgForm;

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

    itemSelec: any;

  constructor(
    private http: HttpClient,
    private router: Router,
    private transferenciaService: TransferenciaService,
    private responseProdutoService: ProdutosService,
    private modal: AlertModalService
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

  listarTodosProdutos() {
    console.log(this.request.idFilial);
    var idFilial = this.request.idFilial.toString();
    this.transferenciaService.getFilialProduto(idFilial).subscribe(response => {
      this.responseEstoque = response;
      this.loading = false;
    });
  }


  selecionarItem(itemSelecionado: any) {
    this.itemSelec = itemSelecionado
  }

  cancelarProduto(){
    console.log("item selecionado cancelar: " + this.itemSelec);
    this.request.itens.splice(this.itemSelec, 1);
  }

   //Famosa gambiarra
   i: number;
  
   itens(): void {
    this.transferenciaService.getProduto(this.item.cdProduto).subscribe(response => {
    this.responseProduto = response
      // console.log(this.responseProduto)
      this.item.nmProduto = this.responseProduto.nm_fantasia;
      this.item.nrItemDocumento = this.i;
      this.request.itens.push(this.item);
      console.log(this.request.itens);
      this.item = new ResponseEntradaItens();
      this.i++;
    })
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
      this.transferenciaService.createTransferencia(this.request).subscribe(
        success => this.modal.showAlertSuccess('Transferência de produto realizada com sucesso!'),
        error => this.modal.showAlertDanger('Erro ao realizar a transferência!'),
        () => console.log('request completo')
      );
      this.router.navigate(['/listaTransferenciaProduto']);
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

  
  validacaoCDProduto(){
    if(this.request.itens.length > 0){
      return true;
    }else{
      return false;
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
