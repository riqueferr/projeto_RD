import { Component, OnInit } from '@angular/core';
import {AppData} from "../../AppData";
import {NgForm} from '@angular/forms';


@Component({
  selector: 'app-cadastro-de-fornecedor',
  templateUrl: './cadastro-de-fornecedor.component.html',
  styleUrls: ['./cadastro-de-fornecedor.component.css']
})
export class CadastroDeFornecedorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(it: NgForm) {
    console.log(it.value);  // { first: '', last: '' }
    console.log(it.valid);  // false
  }

  title = 'app';
  data = new AppData('');


}
