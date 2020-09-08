package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.StatusRepository;
import br.com.pi.projeto_RD.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoProdutoController {

    @Autowired
    TipoProdutoRepository repository;

    @GetMapping("/tipoproduto")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(repository.findAll());
    }

}
