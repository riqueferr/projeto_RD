import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ResponseProdutos } from '../shared/produtos.model';
import { ProdutosService } from '../shared/produtos.service';

@Component({
  selector: 'app-detalhamento-produtos',
  templateUrl: './detalhamento-produtos.component.html',
  styleUrls: ['./detalhamento-produtos.component.css']
})
export class DetalhamentoProdutosComponent implements OnInit {

  codigo: string;
  request: any;
  responseProdutos: ResponseProdutos[];

  constructor(
    private produtoService: ProdutosService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.codigo = this.route.snapshot.paramMap.get('codigo');
    this.produtoService.getProduto(this.codigo).subscribe(response => this.request = response);
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.produtoService.getProdutos().subscribe(response => {
      this.responseProdutos = response;
    });
  }

}
