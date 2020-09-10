import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ResponseRelatorioProduto } from '../shared/relatorioproduto.model';
import { RelatorioProdutoService } from '../shared/relatorioproduto.service';

@Component({
  selector: 'app-lista-nome-produto-relatorio',
  templateUrl: './lista-nome-produto-relatorio.component.html',
  styleUrls: ['./lista-nome-produto-relatorio.component.css']
})
export class ListaNomeProdutoRelatorioComponent implements OnInit {

  public paginaAtual = 1;

  loading : boolean;

  nmProduto: any;
  statusProduto: any;
  request: any;

  responseRelatorioProduto: ResponseRelatorioProduto[];

  constructor(
    private relatorioProdutoService: RelatorioProdutoService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorNmProduto();
  }

  listarPorNmProduto(): void {
    this.nmProduto = this.route.snapshot.paramMap.get('nmProduto');
    this.relatorioProdutoService.getRelatorioProdutoPorNome(this.nmProduto).subscribe(response => {
      this.request = response;
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
