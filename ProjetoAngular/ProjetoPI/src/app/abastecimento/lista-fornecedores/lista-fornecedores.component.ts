import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fornecedores, ResponseFornecedores } from '.././cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '.././cadastro-de-fornecedor/shared/fornecedores.service';

@Component({
  selector: 'app-lista-fornecedores',
  templateUrl: './lista-fornecedores.component.html',
  styleUrls: ['./lista-fornecedores.component.css']
})
export class ListaFornecedoresComponent implements OnInit {

  loading: boolean;

  public paginaAtual = 1;

  idFornecedor: any;

    // Configuração da ordenação
    key: string = 'cd_fornecedor';
    reverse: boolean = false;
    sort(key) {
        this.key = key;
        this.reverse = !this.reverse;
    }

  responseFornecedores: ResponseFornecedores[];
  constructor(
    private fornecedorService: FornecedoresService,
    private router: Router
    ) { }

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


  register(): void {
    if (this.idFornecedor != null && this.idFornecedor > 0) {
      console.log(this.idFornecedor);
      this.fornecedorService.getFornecedor(this.idFornecedor).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaFornecedores', this.idFornecedor]));
    }
    //  else {
    //   console.log(this.nmFilial);
    //   this.entradasService.getFilial(this.nmFilial).subscribe();
    //   this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]);
    // }
  }

}
