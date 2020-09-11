import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { EstoqueService } from '../shared/estoque.service';
import { ResponseEstoque } from '../shared/estoque.model';



@Component({
  selector: 'app-listar-nome-filial',
  templateUrl: './listar-nome-filial.component.html',
  styleUrls: ['./listar-nome-filial.component.css']
})
export class ListarNomeFilialComponent implements OnInit {

  public paginaAtual = 1;

  loading : boolean;
  
  nmFilial: any;
  cdFilial: any;
  request: any;
  responseEstoques: ResponseEstoque[];

  constructor(
    private estoquesService: EstoqueService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorNomeFilial();
  }

  listarPorNomeFilial():void{
    this.nmFilial = this.route.snapshot.paramMap.get('nmFilial');
    this.estoquesService.getEstoqueNomeFilial(this.nmFilial).subscribe(response => {
      this.request = response;
      this.loading = false;
    });
  }

  register(): void {
    if(this.cdFilial != null && this.cdFilial > 0){
      console.log(this.cdFilial);
      this.estoquesService.getEstoqueFilial(this.cdFilial).subscribe();
      this.router.navigateByUrl('/relatorioDeEstoque', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/relatorioDeEstoque/filial', this.cdFilial]));
    }else{
        console.log(this.nmFilial);
        this.estoquesService.getEstoqueNomeFilial(this.cdFilial).subscribe();
        this.router.navigateByUrl('/relatorioDeEstoque', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/relatorioDeEstoque/nomefilial', this.nmFilial]));
    }
  }

}
