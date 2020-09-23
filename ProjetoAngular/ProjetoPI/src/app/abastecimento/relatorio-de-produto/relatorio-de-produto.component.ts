import { Component, OnInit } from '@angular/core';
import { RelatorioProdutoService } from './shared/relatorioproduto.service';
import { ResponseRelatorioProduto } from './shared/relatorioproduto.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-relatorio-de-produto',
  templateUrl: './relatorio-de-produto.component.html',
  styleUrls: ['./relatorio-de-produto.component.css']
})
export class RelatorioDeProdutoComponent implements OnInit {

  public paginaAtual = 1;

  loading : boolean;

  nmProduto: any;
  statusProduto: any;

  // Configuração da ordenação
  key: string = 'cdProduto';
  reverse: boolean = false;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

  responseRelatorioProduto: ResponseRelatorioProduto[];

  constructor(
    private relatorioProdutoService: RelatorioProdutoService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.relatorioProdutoService.getRelatorioEstoque().subscribe(response => {
        this.responseRelatorioProduto = response;
        this.loading = false;
      });
  }

  register(): void {
    if(this.nmProduto != null){
      console.log(this.nmProduto);
      this.relatorioProdutoService.getRelatorioProdutoPorNome(this.nmProduto).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/relatorioDeProduto/nomeproduto', this.nmProduto]));
    }
    else{
        console.log(this.statusProduto);
        this.relatorioProdutoService.getRelatorioProdutoPorStatus(this.statusProduto).subscribe();
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/relatorioDeProduto/statusproduto', this.statusProduto]));
    }
  }

}
