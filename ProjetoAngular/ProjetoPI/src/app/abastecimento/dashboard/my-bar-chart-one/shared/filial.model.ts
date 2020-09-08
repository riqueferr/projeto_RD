export interface ResponseFiliais {
    barChartLabels: ReponseBarChartLabels[],
    barChartData: ResponseBarChartData[]
}

export class ReponseBarChartLabels {
    barChartLabels : String;
}

export class ResponseBarChartData {
    barChartData : String;
}