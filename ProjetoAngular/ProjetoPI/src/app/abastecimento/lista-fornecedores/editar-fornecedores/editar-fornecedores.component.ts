import { FornecedoresService } from './../../cadastro-de-fornecedor/shared/fornecedores.service';
import { Fornecedores } from './../../cadastro-de-fornecedor/shared/fornecedores.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { AlertModalService } from '../../shared/alert-modal.service';

declare var $: any;
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
    this.cd_fornecedor = this.route.snapshot.paramMap.get('cd_fornecedor');
    this.fornecedorService.getFornecedor(this.cd_fornecedor).subscribe(response => this.request = response);
  }

  // onSubmit(it: NgForm) {
  //   console.log(it.value);  // { first: '', last: '' }
  //   console.log(it.valid);  // false
  // }

  update(): void {
    if (this.it.form.valid) {
      this.fornecedorService.updateFornecedor(this.cd_fornecedor, this.request).subscribe(
        success => this.modal.showAlertSuccess('Fornecedor "' + this.request.nm_razao_social + '" foi editado com sucesso!'),
        error => this.modal.showAlertDanger('Erro ao editar o produto ' + this.request.nm_razao_social + '!'),
        () => console.log('request completo')
      );
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
