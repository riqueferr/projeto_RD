import { Component, OnInit } from '@angular/core';
import { EstoqueService } from '../shared/estoque.service';
import { ResponseEstoque } from '../shared/estoque.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listar-id-filial',
  templateUrl: './listar-id-filial.component.html',
  styleUrls: ['./listar-id-filial.component.css']
})
export class ListarIdFilialComponent implements OnInit {

  loading : boolean;

  responseEstoques: ResponseEstoque[];

  codigo: string;

  constructor(
    private estoquesService: EstoqueService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosProdutos();
  }

  // listarTodosProdutos() {
  //   this.estoquesService.getEstoque(this.codigo).subscribe(response => 
  //     {
  //       this.loading = false;
  //       // this.router.navigate(['/listaProdutos']);
  //       // this.responseEstoques = response;
  //     });
  // }

  listarTodosProdutos() {
    this.estoquesService.getEstoques().subscribe(response => 
      {
        this.responseEstoques = response;
        this.loading = false;
      });
  }

}
