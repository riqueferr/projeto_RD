import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProdutosService } from '../shared/produtos.service';


@Component({
  selector: 'app-editar-produtos',
  templateUrl: './editar-produtos.component.html',
  styleUrls: ['./editar-produtos.component.css']
})
export class EditarProdutosComponent implements OnInit {

  @ViewChild('formProduto', { static: true }) formProduto: NgForm;

  codigo: string;
  request: any;

  constructor(
    private produtosService: ProdutosService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.codigo = this.route.snapshot.paramMap.get('codigo');
    this.produtosService.getProduto(this.codigo).subscribe(response => this.request = response);
  }

  update(): void {
    if (this.formProduto.form.valid) {
      this.produtosService.updateProduto(this.codigo, this.request).subscribe();
      this.router.navigate(['/listaProdutos']);
    }
  }
}
