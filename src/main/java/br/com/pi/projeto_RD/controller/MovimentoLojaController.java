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


    @GetMapping("/movimentoloja/pagamento/{data}")
    public ResponseEntity buscarPorPagamento(@PathVariable("data") Date data) { return ResponseEntity.ok().body(service.buscarPagamento(data));}

    @GetMapping("/movimentoloja/pagamento/dinheiro")
    public ResponseEntity buscarPorPagamentoDinheiro() { return ResponseEntity.ok().body(service.buscarPagamentoDinheiro());}

    @GetMapping("/movimentoloja/pagamento/cheque")
    public ResponseEntity buscarPorPagamentoCheque() { return ResponseEntity.ok().body(service.buscarPagamentoCheque());}

    @GetMapping("/movimentoloja/pagamento/teste/{data}/{filial}")
    public ResponseEntity buscarPorPagamentoTeste(@PathVariable("data")Date data, @PathVariable("filial") Long filial) { return ResponseEntity.ok().body(service.buscarTeste(data,filial));}

    @GetMapping("/movimentoloja/pagamento/dinheiro/{data}/{filial}")
    public ResponseEntity somarDinheiro(@PathVariable("data")Date data, @PathVariable("filial") Long filial) { return ResponseEntity.ok().body(service.somarDinheiro(data,filial));}

    @GetMapping("/movimentoloja/pagamento/cheque/{data}/{filial}")
    public ResponseEntity somarCheque(@PathVariable("data")Date data, @PathVariable("filial") Long filial) { return ResponseEntity.ok().body(service.somarCheque(data,filial));}
}
