package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.ChartDataDTO;
import br.com.pi.projeto_RD.model.dto.FilialProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ChartDataController {

    @GetMapping("/filial/produtos/lista")
    public ResponseEntity buscarQuantidadeProdutosPorLoja(){
        FilialProdutoDTO dto = new FilialProdutoDTO();
        List<String> barChartLabels = new ArrayList<>();
        barChartLabels.add("Butantã");
        barChartLabels.add("Corifeu");
        barChartLabels.add("Jaguaré");
        List<ChartDataDTO> barChartData = new ArrayList<>();
        ChartDataDTO dataDTO = new ChartDataDTO();
        dataDTO.setData(Arrays.asList(10000L, 8000L, 5000L));
        barChartData.add(dataDTO);
        dto.setBarChartLabels(barChartLabels);
        dto.setBarChartData(barChartData);
        return ResponseEntity.ok(dto);
    }
}
