import { Component, OnInit } from '@angular/core';
import { FilialService } from './shared/filial.service';
import { ResponseFiliais } from './shared/filial.model';

@Component({
  selector: 'app-my-bar-chart-one',
  templateUrl: './my-bar-chart-one.component.html',
  styleUrls: ['./my-bar-chart-one.component.css']
})
export class MyBarChartOneComponent implements OnInit {

  responseFiliais: ResponseFiliais;

  constructor(private filialService: FilialService) { }
  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true,
    maintainAspectRatio: false
  };
  public barChartLabels = [];
  public barChartType = 'bar';
  public barChartLegend = false;
  public barChartData = [];
  
  ngOnInit() {
    this.listarTodasFiliais();
  }


  listarTodasFiliais() {
    this.filialService.getBuscarQuantidadeProdutosPorLoja().subscribe(response => {
      this.responseFiliais = response;
      this.barChartData = response.barChartData;
      this.barChartLabels = response.barChartLabels;
      // console.log(response);
    });
  }
}
