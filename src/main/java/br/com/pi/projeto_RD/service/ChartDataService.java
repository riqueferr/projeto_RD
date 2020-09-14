package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.ChartDataDTO;
import br.com.pi.projeto_RD.model.dto.FilialProdutoDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.bo.ChartDataBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
public class ChartDataService {

    @Autowired
    private ProdutoFilialEstoqueRepository repository;

    public FilialProdutoDTO consultarProdutoPorLoja(){

        FilialProdutoDTO dto = new FilialProdutoDTO();

        List<ChartDataDTO> barChartData = new ArrayList<>();
        ChartDataDTO dataDTO = new ChartDataDTO();
        List<ProdutoFilialEstoqueEntity> estoques = repository.findAll();
        Map<String, Integer> mapFilial = new HashMap<>();
        for(ProdutoFilialEstoqueEntity estoque : estoques){
            String nomeFilial = estoque.getFilial().getNmFilial();
            if(mapFilial.containsKey(nomeFilial)){
                Integer qtProdutos = mapFilial.get(nomeFilial);
                mapFilial.put(nomeFilial, qtProdutos + estoque.getQt_estoque());
            }else{
                mapFilial.put(nomeFilial, estoque.getQt_estoque());
            }
        }

        Iterator<Map.Entry<String, Integer>> it = mapFilial.entrySet().iterator();
        List<String> barChartLabels = new ArrayList<>();
        while(it.hasNext()){
            String nomeFilial = it.next().getKey();
            Integer qtdProduto = mapFilial.get(nomeFilial);
            barChartLabels.add(nomeFilial);
            dataDTO.addData(qtdProduto);
        }
        barChartData.add(dataDTO);
        dto.setBarChartLabels(barChartLabels);
        dto.setBarChartData(barChartData);
        return dto;
    }
}

