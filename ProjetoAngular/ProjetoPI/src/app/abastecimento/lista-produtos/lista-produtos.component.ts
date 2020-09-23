import { Component, OnInit } from '@angular/core';
import { ProdutosService } from './shared/produtos.service';
import { ResponseProdutos } from './shared/produtos.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;
  idProduto: any;

    // Configuração da ordenação
    key: string = 'codigo';
    reverse: boolean = false;
    sort(key) {
        this.key = key;
        this.reverse = !this.reverse;
    }

  responseProdutos: ResponseProdutos[];

  constructor(
    private produtosService: ProdutosService,
    private router: Router
    ) { }

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

  register(): void {
    if (this.idProduto != null && this.idProduto > 0) {
      console.log(this.idProduto);
      this.produtosService.getProduto(this.idProduto).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaProdutos', this.idProduto]));
    }
    //  else {
    //   console.log(this.nmFilial);
    //   this.entradasService.getFilial(this.nmFilial).subscribe();
    //   this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]);
    // }
  }

}
