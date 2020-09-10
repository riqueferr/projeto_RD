package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.service.RelatorioGerencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class RelatorioGerencialController {

    @Autowired
    private RelatorioGerencialService service;

    @GetMapping("/relatoriogerencial/vendas/{data}/{filial}")
    public ResponseEntity buscarTudo(@PathVariable("data") Date data, @PathVariable("filial")Long filial){
        return ResponseEntity.ok().body(service.buscarVendasDiarias(data, filial));
    }
}
