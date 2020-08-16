package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoFilialEstoqueController {

    @Autowired
    ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    @GetMapping("/filial-estoque")
    @ApiOperation(value = "Listar todas os produtos")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(produtoFilialEstoqueRepository.findAll());
    }

}
