import { Component, OnInit } from '@angular/core';
import { EstoqueService } from './shared/estoque.service';
import { ResponseEstoque } from './shared/estoque.model';

@Component({
  selector: 'app-relatorio-de-estoque',
  templateUrl: './relatorio-de-estoque.component.html',
  styleUrls: ['../../app.component.css']
})
export class RelatorioDeEstoqueComponent implements OnInit {

  loading : boolean;

  responseEstoques: ResponseEstoque[];

  constructor(private estoquesService: EstoqueService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.estoquesService.getEstoques().subscribe(response => 
      {
        this.responseEstoques = response;
        this.loading = false;
      });
  }

}
