import { FornecedoresService } from './shared/fornecedores.service';
import { Fornecedores } from './shared/fornecedores.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';
import { validate, format, generate } from 'cnpj';
import { AlertModalService } from '../shared/alert-modal.service';


declare var $: any;
// const valid2 = validate('57.865.533/0001-53');
// console.log(valid2);

@Component({
  selector: 'app-cadastro-de-fornecedor',
  templateUrl: './cadastro-de-fornecedor.component.html',
  styleUrls: ['./cadastro-de-fornecedor.component.css']
})
export class CadastroDeFornecedorComponent implements OnInit {

  @ViewChild('it', { static: true }) it: NgForm;

  request: Fornecedores = {
    cd_fornecedor: null,
    nr_cnpj: null,
    nm_razao_social: null,
    ds_denominacao: null,
    nr_inscricao: null,
    ds_email: null,
    nr_telefone: null,
    nr_celular: null,
    fk_tipo_fornecedor: {
      id_tipo_fornecedor: null,
      ds_tipo_fornecedor: null
    },
    endereco: [
      {
        dsEndereco: null,
        nrEndereco: null,
        nrCep: null,
        dsBairro: null,
        dsCidade: null,
        sgEstado: null,
        nmComplemento: null
      }
    ]

  };

  constructor(
    private http: HttpClient,
    private fornecedorService: FornecedoresService,
    private router: Router,
    private modal: AlertModalService
  ) { }

  ngOnInit(): void {
    $(document).ready(function () {
      $('#cpf').mask('000.000.000-00');
      $('#cnpj').mask('00.000.000/0000-00');
      $('#cep').mask('00000-000');
      $('#phone').mask('(00) 0000-0000');
      $('#cell').mask('(00) 00000-0000');
      $('#numeroInscricao').mask('000.000.000.000');
    });
  }

  // tslint:disable-next-line: typedef
  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  validar() {
    let valida = validate(this.request.nr_cnpj);
    return valida;
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
      tipoFornecedor: form.value.tipoFornecedor,
      razaoSocial: form.value.razaoSocial,
      denominacaoSocial: form.value.denominacaoSocial,
      numeroInscricao: form.value.numeroInscricao,
      email: form.value.email,
      telefone: form.value.telefone,
      celular: form.value.celular,
      logradouro: dados.logradouro,
      cep: dados.cep,
      numero: '',
      complemento: '',
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf
    });
  }

  register(): void {
    if (this.it.form.valid) {
      console.log(this.request);
      this.fornecedorService.createFornecedor(this.request).subscribe(
        success => this.modal.showAlertSuccess('Fornecedor "' + this.request.nm_razao_social +  '" cadastrado com sucesso!'),
        error => this.modal.showAlertDanger('Erro ao cadastrar o fornecedor!'),
        () => console.log('request completo')
      );
      this.router.navigate(['/listaFornecedores']);
    }
  }
}
