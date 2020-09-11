package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.ChartDataDTO;
import br.com.pi.projeto_RD.model.dto.FilialProdutoDTO;
import br.com.pi.projeto_RD.service.ChartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ChartDataController {

    @Autowired
    private ChartDataService service;

    @GetMapping("/filial/produtos/lista")
    public ResponseEntity buscarQuantidadeProdutosPorLoja(){
        return ResponseEntity.ok(service.consultarProdutoPorLoja());
    }
}
