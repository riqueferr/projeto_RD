package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.FilialService;
import br.com.pi.projeto_RD.service.RelatorioEstoqueService;
import br.com.pi.projeto_RD.service.RelatorioProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class RelatorioEstoqueController {

    @Autowired
    FilialRepository repository;

    @Autowired
    private RelatorioEstoqueService service;

    //LISTAR TODOS
    @GetMapping("/relatorioestoque")
    @ApiOperation(value = "Listar relatório estoque de todas filiais")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //LISTAR POR ID
    @GetMapping("/relatorioestoque/{codigo}")
    @ApiOperation(value = "Listar relatório estoque das filiais por ID FILIAL")
    public ResponseEntity buscarPorId(@PathVariable("codigo") BigInteger codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

}
