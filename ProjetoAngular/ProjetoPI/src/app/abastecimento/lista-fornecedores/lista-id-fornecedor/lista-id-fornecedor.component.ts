import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResponseFornecedores } from '../../cadastro-de-fornecedor/shared/fornecedores.model';
import { FornecedoresService } from '../../cadastro-de-fornecedor/shared/fornecedores.service';

@Component({
  selector: 'app-lista-id-fornecedor',
  templateUrl: './lista-id-fornecedor.component.html',
  styleUrls: ['./lista-id-fornecedor.component.css']
})
export class ListaIdFornecedorComponent implements OnInit {

  idFornecedor: any;
  request: any;

  responseFornecedores: ResponseFornecedores[];

  constructor(
    private fornecedorService: FornecedoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.idFornecedor = this.route.snapshot.paramMap.get('idFornecedor');
    this.fornecedorService.getFornecedor(this.idFornecedor).subscribe(response => {
      this.request = response;
    });
  }

  register(): void {
    if (this.idFornecedor != null && this.idFornecedor > 0) {
      console.log(this.idFornecedor);
      this.fornecedorService.getFornecedor(this.idFornecedor).subscribe();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaFornecedores', this.idFornecedor]));
    }else{
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/listaFornecedores']));
    }
    //  else {
    //   console.log(this.nmFilial);
    //   this.entradasService.getFilial(this.nmFilial).subscribe();
    //   this.router.navigate(['/listaEntradaProdutos/filial', this.nmFilial]);
    // }
  }

}
