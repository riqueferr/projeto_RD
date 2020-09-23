import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProdutosService } from '../lista-produtos/shared/produtos.service';
import { Produtos, ResponseProdutos, ResponseSubCategorias, ResponseStatus, ResponseTipoProduto } from '../lista-produtos/shared/produtos.model'

import { ResponseFornecedores } from '../cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '../cadastro-de-fornecedor/shared/fornecedores.service';
import { AlertModalService } from '../shared/alert-modal.service';

declare var $: any;

@Component({
  selector: 'app-cadastro-de-produto',
  templateUrl: './cadastro-de-produto.component.html',
  styleUrls: ['../../app.component.css']
})
export class CadastroDeProdutoComponent implements OnInit {

  @ViewChild('formProdutos', { static: true }) formProdutos: NgForm;

  loading: boolean;

  responseProdutos: ResponseProdutos[];
  responseSubCategorias: ResponseSubCategorias[];
  responseFornecedores: ResponseFornecedores[];
  responseStatus: ResponseStatus[];
  responseTipoProduto: ResponseTipoProduto[];

  request: Produtos = {
    nm_fantasia: null,
    statusProduto: {
      idStatusProduto: null
    },
    subCategoria: {
      idSubCategoria: null,
      dsSubCategoria: null
    },
    tipo_produto: {
      idTipoProduto: null
    },
    nm_fabricante: null,
    vl_unidade: null,
    dsProduto: null,
    fornecedor: [
      {
        cd_fornecedor: null
      }
    ]
  };

  constructor(
    private produtosService: ProdutosService,
    private responseFornecedoresService: FornecedoresService,
    private router: Router,
    private modal: AlertModalService
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTipoProdutos();
    this.listarTodasCategorias();
    this.listarTodosFornecedores();
    this.listarStatus();

    $(document).ready(function() {
      $('.data').mask('00/00/0000');
    });
  }
  
  onSubmit(formProdutos: NgForm) {
    console.log(formProdutos.value);  // { first: '', last: '' }
    console.log(formProdutos.valid);  // false
  }

  register(): void {
    if (this.formProdutos.form.valid) {
      this.produtosService.createProduto(this.request).subscribe(
        success => this.modal.showAlertSuccess('Produto "' + this.request.nm_fantasia +  '" foi cadastrado com sucesso!'),
        error => this.modal.showAlertDanger('Erro ao cadastrar o produto!'),
        () => console.log('request completo')
      );
      this.router.navigate(["/listaProdutos"]);
    }
  }

  listarTodasCategorias() {
    this.produtosService.getSubCategoria().subscribe(response => {
      this.responseSubCategorias = response;
    });
  }

  listarStatus() {
    this.produtosService.getStatus().subscribe(response => {
      this.responseStatus = response;
    });
  }

  listarTipoProdutos() {
    this.produtosService.getTipoProduto().subscribe(response => {
      this.responseTipoProduto = response;
    });
  }

  listarTodosFornecedores() {
    this.responseFornecedoresService.getFornecedores().subscribe(response => {
      this.responseFornecedores = response;
      this.loading = false;
    });
  }

}
