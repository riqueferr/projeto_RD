package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.FilialEstoqueService;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoFilialEstoqueController {

    @Autowired
    ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    @Autowired
    FilialEstoqueService pfBO;


    @GetMapping("/FilialEstoque")
    @ApiOperation(value = "Listar todas os produtos")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(pfBO.buscarTodos());
    }

    @GetMapping("/FilialEstoque/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {
        return ResponseEntity.ok().body(pfBO.buscarPorId(codigo));
    }

}
