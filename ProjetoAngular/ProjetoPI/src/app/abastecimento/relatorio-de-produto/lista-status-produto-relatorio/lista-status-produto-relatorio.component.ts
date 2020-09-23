import { Component, OnInit } from '@angular/core';
import { RelatorioProdutoService } from '../shared/relatorioproduto.service';
import { ResponseRelatorioProduto } from '../shared/relatorioproduto.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lista-status-produto-relatorio',
  templateUrl: './lista-status-produto-relatorio.component.html',
  styleUrls: ['./lista-status-produto-relatorio.component.css']
})
export class ListaStatusProdutoRelatorioComponent implements OnInit {

  public paginaAtual = 1;

  loading : boolean;

  nmProduto: any;
  statusProduto: any;
  request: any;

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
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorStatus();
  }

  listarPorStatus(): void {
    this.statusProduto = this.route.snapshot.paramMap.get('statusProduto');
    this.relatorioProdutoService.getRelatorioProdutoPorStatus(this.statusProduto).subscribe(response => {
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
