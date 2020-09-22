import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ResponseProdutos } from '../shared/produtos.model';
import { ProdutosService } from '../shared/produtos.service';

@Component({
  selector: 'app-lista-id-produto',
  templateUrl: './lista-id-produto.component.html',
  styleUrls: ['./lista-id-produto.component.css']
})
export class ListaIdProdutoComponent implements OnInit {

  idProduto: any;
  request: any;

  responseProdutos: ResponseProdutos[];

  constructor(
    private produtosService: ProdutosService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.idProduto = this.route.snapshot.paramMap.get('idProduto');
    this.produtosService.getProduto(this.idProduto).subscribe(response => {
      this.request = response;
    });
  }

  register(): void {
    if (this.idProduto != null && this.idProduto > 0) {
      console.log(this.idProduto);
      this.produtosService.getProduto(this.idProduto).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaProdutos', this.idProduto]));
    }else{
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaProdutos']));
    }
    //  else {
    //   console.log(this.nmFilial);
    //   this.entradasService.getFilial(this.nmFilial).subscribe();
    //   this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]);
    // }
  }

}
