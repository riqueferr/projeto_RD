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

    this.http.post('http://localhost:8080/abastecimento/fornecedores', JSON.stringify(it.value));
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
// {
//   "nr_cnpj": "2222/0240-93",
//   "nm_razao_social": "RaiaDrogasil SA",
//   "ds_denominacao": "Needs",
//   "nr_inscricao": "123412345",
//   "ds_email": "needs.contato@rd.com.br",
//   "nr_telefone": "(11) 3765-2376",
//   "fk_tipo_fornecedor": {
//       "id_tipo_fornecedor": 2,
//       "ds_tipo_fornecedor": "Monopolista"
//   },
//   "endereco": [
//       {
//           "dsEndereco": "Av Ibirama",
//           "nrCep": "45454",
//           "dsBairro": "JD Iba",
//           "dsCidade": "São Paulo",
//           "sgEstado": "SP",
//           "nmComplemento": "A"
//       }
//   ]
// }
