import { Component, OnInit } from '@angular/core';
import { Fornecedores, ResponseFornecedores } from '.././cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '.././cadastro-de-fornecedor/shared/fornecedores.service';

@Component({
  selector: 'app-lista-fornecedores',
  templateUrl: './lista-fornecedores.component.html',
  styleUrls: ['./lista-fornecedores.component.css']
})
export class ListaFornecedoresComponent implements OnInit {

  loading: boolean;

  responseFornecedores: ResponseFornecedores[];
  constructor(private fornecedorService: FornecedoresService) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodosFornecedores();
  }

  listarTodosFornecedores() {
    this.fornecedorService.getFornecedores().subscribe(response => {
      this.responseFornecedores = response;
      this.loading = false;
    });
  }
}
