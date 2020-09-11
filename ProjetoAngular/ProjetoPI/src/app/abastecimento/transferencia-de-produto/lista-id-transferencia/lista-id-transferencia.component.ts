import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TransferenciaService } from '../shared/transferencia.service';
import { ResponseTransferencia } from '../shared/transferencia.model';

@Component({
  selector: 'app-lista-id-transferencia',
  templateUrl: './lista-id-transferencia.component.html',
  styleUrls: ['./lista-id-transferencia.component.css']
})
export class ListaIdTransferenciaComponent implements OnInit {

  @ViewChild('it', { static: true }) formDF: NgForm;
  
  loading: boolean;

  idDF: any;
  nmFilialDestino: any;
  request: any;

  responseTransferencia: ResponseTransferencia[];

  constructor(
    private responseService: TransferenciaService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.idDF = this.route.snapshot.paramMap.get('idDF');
    this.responseService.getTransferencia(this.idDF).subscribe(response => {
      this.request = response;
      this.loading = false;
    });
  }

  register(): void {
    if (this.idDF != null && this.idDF > 0) {
      console.log(this.idDF);
      this.responseService.getTransferencia(this.idDF).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaTransferenciaProduto', this.idDF]));
    }
    else {
      console.log(this.nmFilialDestino);
      this.responseService.getPesquisaFilialTransferencia(this.nmFilialDestino).subscribe();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(['/listaTransferenciaProduto/filial', this.nmFilialDestino]));
    }
  }

}
