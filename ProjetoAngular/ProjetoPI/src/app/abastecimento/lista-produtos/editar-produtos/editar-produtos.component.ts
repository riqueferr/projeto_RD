import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ResponseFornecedores } from '../../cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '../../cadastro-de-fornecedor/shared/fornecedores.service';
import { AlertModalService } from '../../shared/alert-modal.service';
import { ResponseStatus, ResponseSubCategorias, ResponseTipoProduto } from '../shared/produtos.model';
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

  responseSubCategorias: ResponseSubCategorias[];
  responseFornecedores: ResponseFornecedores[];
  responseStatus: ResponseStatus[];
  responseTipoProduto: ResponseTipoProduto[];

  constructor(
    private produtosService: ProdutosService,
    private responseFornecedoresService: FornecedoresService,
    private route: ActivatedRoute,
    private router: Router,
    private modal: AlertModalService
  ) { }

  ngOnInit(): void {
    this.codigo = this.route.snapshot.paramMap.get('codigo');
    this.produtosService.getProduto(this.codigo).subscribe(response => this.request = response);
    this.listarTipoProdutos();
    this.listarTodasCategorias();
    this.listarTodosFornecedores();
    this.listarStatus();
  }

  update(): void {
    if (this.formProduto.form.valid) {
      this.produtosService.updateProduto(this.codigo, this.request).subscribe(
        success => this.modal.showAlertSuccess('Produto "' + this.request.nm_fantasia +  '" foi editado com sucesso!'),
        error => this.modal.showAlertDanger('Erro ao editar o produto ' + this.request.nm_fantasia + '!'),
        () => console.log('request completo')
      );
      this.router.navigate(['/listaProdutos']);
    }
  }

  listarTodasCategorias() {
    this.produtosService.getSubCategoria().subscribe(response => {
      this.responseSubCategorias = response;
    });
  }

  listarStatus() {
    this.produtosService.getStatus().subscribe(response => {
      this.responseStatus = response;
    });
  }

  listarTipoProdutos() {
    this.produtosService.getTipoProduto().subscribe(response => {
      this.responseTipoProduto = response;
    });
  }

  listarTodosFornecedores() {
    this.responseFornecedoresService.getFornecedores().subscribe(response => {
      this.responseFornecedores = response;
    });
  }

}
