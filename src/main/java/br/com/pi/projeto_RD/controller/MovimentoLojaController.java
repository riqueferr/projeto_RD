package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.service.MovimentoLojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class MovimentoLojaController {

    @Autowired
    private MovimentoLojaService service;

    //BUSCAR TODOS
    @GetMapping("/movimentoloja")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/movimentoloja/data/{data}")
    public ResponseEntity buscarPorData(@PathVariable("data") Date data ) { return ResponseEntity.ok().body(service.buscarData(data));
    }


    @GetMapping("/movimentoloja/pagamento/{teste}")
    public ResponseEntity buscarPorPagamento(@PathVariable("teste") Long teste) { return ResponseEntity.ok().body(service.buscarPagamento(teste));}
}
