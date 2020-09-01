import { Component, OnInit } from '@angular/core';
import { ProdutosService } from './shared/produtos.service';
import { ResponseProdutos } from './shared/produtos.model';


@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;

  responseProdutos: ResponseProdutos[];

  constructor(private produtosService: ProdutosService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.produtosService.getProdutos().subscribe(response => {
      this.responseProdutos = response;
      this.loading = false;
    });
  }
}
