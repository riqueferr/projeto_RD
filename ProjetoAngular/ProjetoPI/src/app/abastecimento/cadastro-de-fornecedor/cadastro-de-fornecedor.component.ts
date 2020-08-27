import { Component, OnInit } from '@angular/core';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-cadastro-de-fornecedor',
  templateUrl: './cadastro-de-fornecedor.component.html',
  styleUrls: ['./cadastro-de-fornecedor.component.css']
})
export class CadastroDeFornecedorComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line: typedef
  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  // tslint:disable-next-line: typedef
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
