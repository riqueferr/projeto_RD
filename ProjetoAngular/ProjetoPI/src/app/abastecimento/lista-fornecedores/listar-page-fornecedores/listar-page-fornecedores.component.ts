import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ResponseFornecedores } from '../../cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '../../cadastro-de-fornecedor/shared/fornecedores.service';

@Component({
  selector: 'app-listar-page-fornecedores',
  templateUrl: './listar-page-fornecedores.component.html',
  styleUrls: ['./listar-page-fornecedores.component.css']
})
export class ListarPageFornecedoresComponent implements OnInit {

  // loading: boolean;

  public paginaAtual = 0;

  page: any;
  request: any;
  responseFornecedores: ResponseFornecedores[];

  constructor(
    private fornecedorService: FornecedoresService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.page = this.route.snapshot.paramMap.get('page');
    this.fornecedorService.getFornecedorPage(this.page).subscribe(response => this.request = response);
  }

  register(): void {
    console.log(this.page);
    this.fornecedorService.getFornecedorPage(this.page).subscribe();
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
    this.router.navigate(['/listaFornecedores', this.page]));
}

}
