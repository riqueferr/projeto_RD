import { FornecedoresService } from './../../cadastro-de-fornecedor/shared/fornecedores.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-editar-fornecedores',
  templateUrl: './editar-fornecedores.component.html',
  styleUrls: ['./editar-fornecedores.component.css']
})
export class EditarFornecedoresComponent implements OnInit {

  @ViewChild('it', { static: true }) it: NgForm;

  cd_fornecedor: string;
  request: any;

  constructor(
    private http: HttpClient,
    private fornecedorService: FornecedoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.cd_fornecedor = this.route.snapshot.paramMap.get('cd_fornecedor');
    this.fornecedorService.getFornecedor(this.cd_fornecedor).subscribe(response => this.request = response);
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  update(): void {
    if (this.it.form.valid) {
      this.fornecedorService.updateFornecedor(this.cd_fornecedor, this.request).subscribe();
      this.router.navigate(['/listaFornecedores']);
    }
  }
  consultaCEP(cep, form) {

    // Nova variável "cep" somente com dígitos.
    cep = cep.replace(/\D/g, '');

    // Verifica se campo cep possui valor informado.
    // tslint:disable-next-line: triple-equals
    if (cep != '') {

      // Expressão regular para validar o CEP.
      // tslint:disable-next-line: prefer-const
      let validacep = /^[0-9]{8}$/;

      // Valida o formato do CEP.
      if (validacep.test(cep)) {
        this.http.get(`//viacep.com.br/ws/${cep}/json`)
          .pipe(map(dados => dados))
          .subscribe(dados => this.populaDadosForm(dados, form));
        // .subscribe(dados => console.log(dados));

      }
    }
  }

  populaDadosForm(dados, form) {
    form.setValue({
      cnpj: form.value.cnpj,
      tipoFornecedor: form.value.tipoFornecedor,
      razaoSocial: form.value.razaoSocial,
      denominacaoSocial: form.value.denominacaoSocial,
      numeroInscricao: form.value.numeroInscricao,
      email: form.value.email,
      telefone: form.value.telefone,
      rua: dados.logradouro,
      cep: dados.cep,
      numero: '',
      complemento: '',
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf
    });
  }
}
