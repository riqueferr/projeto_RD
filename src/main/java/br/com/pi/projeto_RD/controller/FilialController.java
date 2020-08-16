package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilialController {

    @Autowired
    FilialRepository repository;

    @Autowired
    private FilialService service;

    @GetMapping("/filial")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }
}
