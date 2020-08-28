import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-bar-chart-one',
  templateUrl: './my-bar-chart-one.component.html',
  styleUrls: ['./my-bar-chart-one.component.css']
})
export class MyBarChartOneComponent implements OnInit {
  constructor() { }
  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true,
    maintainAspectRatio: false
  };
  public barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  ];
  ngOnInit() {
  }
}
