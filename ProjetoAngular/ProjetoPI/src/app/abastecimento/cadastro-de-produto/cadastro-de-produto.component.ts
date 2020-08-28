import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProdutosService } from '../lista-produtos/shared/produtos.service';
import { Produtos } from '../lista-produtos/shared/produtos.model'



@Component({
  selector: 'app-cadastro-de-produto',
  templateUrl: './cadastro-de-produto.component.html',
  styleUrls: ['../../app.component.css']
})
export class CadastroDeProdutoComponent implements OnInit {

  @ViewChild('formProdutos', { static: true }) formProdutos: NgForm;

  request: Produtos = {
    nm_fantasia: null,
    statusProduto: {
      idStatusProduto: null
    },
    categoria: {
      idCategoria: null
    },
    tipo_produto: {
      idTipoProduto: null
    },
    nm_fabricante: null,
    vl_unidade: null,
    fornecedor: [
      {
        cd_fornecedor: null
      }
    ]
  };

  constructor(
    private produtosService: ProdutosService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  onSubmit(formProdutos: NgForm) {
    console.log(formProdutos.value);  // { first: '', last: '' }
    console.log(formProdutos.valid);  // false
  }

  register(): void {
    if (this.formProdutos.form.valid) {
      this.produtosService.createProduto(this.request).subscribe();
      this.router.navigate(["/listaProdutos"]);
    }

  }
}
