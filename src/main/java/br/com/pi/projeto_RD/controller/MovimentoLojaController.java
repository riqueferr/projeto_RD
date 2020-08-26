package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.service.MovimentoLojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimentoLojaController {

    @Autowired
    private MovimentoLojaService service;

    //BUSCAR TODOS
    @GetMapping("/movimentoloja")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

}
