package br.com.pi.projeto_RD.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilialProdutoDTO {
    private List<String> barChartLabels;
    private List<ChartDataDTO> barChartData;
}
