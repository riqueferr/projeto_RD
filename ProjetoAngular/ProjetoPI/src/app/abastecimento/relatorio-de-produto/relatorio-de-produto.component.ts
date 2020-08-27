import { Component, OnInit } from '@angular/core';
import { RelatorioProdutoService } from './shared/relatorioproduto.service';
import { ResponseRelatorioProduto } from './shared/relatorioproduto.model';

@Component({
  selector: 'app-relatorio-de-produto',
  templateUrl: './relatorio-de-produto.component.html',
  styleUrls: ['./relatorio-de-produto.component.css']
})
export class RelatorioDeProdutoComponent implements OnInit {

  loading : boolean;

  responseRelatorioProduto: ResponseRelatorioProduto[];

  constructor(private relatorioProdutoService: RelatorioProdutoService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.relatorioProdutoService.getRelatorioEstoque().subscribe(response => 
      {
        this.responseRelatorioProduto = response;
        this.loading = false;
      });
  }

}
