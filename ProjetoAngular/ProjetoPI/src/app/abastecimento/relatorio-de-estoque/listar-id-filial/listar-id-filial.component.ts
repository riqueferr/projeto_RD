import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { EstoqueService } from '../shared/estoque.service';
import { ResponseEstoque } from '../shared/estoque.model';

@Component({
  selector: 'app-listar-id-filial',
  templateUrl: './listar-id-filial.component.html',
  styleUrls: ['./listar-id-filial.component.css']
})
export class ListarIdFilialComponent implements OnInit {

  public paginaAtual = 1;

  loading : boolean;
  
  cdFilial: any;
  nmFilial: any;
  request: any;
  responseEstoques: ResponseEstoque[];

  constructor(
    private estoquesService: EstoqueService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarPorCdFilial();
  }

  listarPorCdFilial():void{
    this.cdFilial = this.route.snapshot.paramMap.get('cdFilial');
    this.estoquesService.getEstoqueFilial(this.cdFilial).subscribe(response => {
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
