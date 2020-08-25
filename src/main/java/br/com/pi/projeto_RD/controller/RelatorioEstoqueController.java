package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.FilialService;
import br.com.pi.projeto_RD.service.RelatorioEstoqueService;
import br.com.pi.projeto_RD.service.RelatorioProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelatorioEstoqueController {

    @Autowired
    FilialRepository repository;

    @Autowired
    private RelatorioEstoqueService service;

    //LISTAR TODOS
    @GetMapping("/relatorioestoque")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //LISTAR POR ID
    @GetMapping("/relatorioestoque/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

}
