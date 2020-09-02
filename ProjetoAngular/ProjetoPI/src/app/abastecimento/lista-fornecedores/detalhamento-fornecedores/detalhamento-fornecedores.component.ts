import { ResponseFornecedores } from './../../cadastro-de-fornecedor/shared/fornecedores.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { FornecedoresService } from '../../cadastro-de-fornecedor/shared/fornecedores.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalhamento-fornecedores',
  templateUrl: './detalhamento-fornecedores.component.html',
  styleUrls: ['./detalhamento-fornecedores.component.css']
})
export class DetalhamentoFornecedoresComponent implements OnInit {

  @ViewChild('it', { static: true }) it: NgForm;

  cd_fornecedor: string;
  request: any;
  responseFornecedores: ResponseFornecedores[];

  constructor(
    private fornecedorService: FornecedoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.cd_fornecedor = this.route.snapshot.paramMap.get('cd_fornecedor');
    this.fornecedorService.getFornecedor(this.cd_fornecedor).subscribe(response => this.request = response);
    this.listarTodosFornecedores();
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  listarTodosFornecedores() {
    this.fornecedorService.getFornecedores().subscribe(response => {
      this.responseFornecedores = response;

    });
  }
}
