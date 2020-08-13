package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.CategoriaRepository;
import br.com.pi.projeto_RD.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    OperadorRepository repository;

    @GetMapping("/operadores")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
