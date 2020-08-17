package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.repository.CategoriaRepository;
import br.com.pi.projeto_RD.repository.OperadorRepository;
import br.com.pi.projeto_RD.service.OperadorService;
import br.com.pi.projeto_RD.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    private OperadorRepository repository;

    @Autowired
    private OperadorService service;

    @GetMapping("/operadores")
    @ApiOperation(value = "Listar todas os operadores")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.listarTodas());
    }

    @GetMapping("/operadores/{codigo}")
    @ApiOperation(value = "Listar todas os operadores por ID")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }


}
