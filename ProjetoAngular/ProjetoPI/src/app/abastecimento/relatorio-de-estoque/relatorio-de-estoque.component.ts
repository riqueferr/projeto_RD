import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

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

  cdFilial: any;

  constructor(
    private estoquesService: EstoqueService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  listarTodosProdutos() {
    this.estoquesService.getEstoques().subscribe(response => {
        this.responseEstoques = response;
        this.loading = false;
      });
  }

  register(): void {
    console.log(this.cdFilial);
    this.estoquesService.getEstoqueFilial(this.cdFilial).subscribe();
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
    this.router.navigate(['/relatorioDeEstoque/filial', this.cdFilial]));
  }

}
