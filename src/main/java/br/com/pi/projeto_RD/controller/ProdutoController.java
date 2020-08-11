package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/produtos")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.buscarTodas());
    }

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {

        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @PostMapping("/produtos")
    public ResponseEntity inserir(@RequestBody ProdutoDto dto) {
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/produtos")
    public ResponseEntity atualizar(@RequestBody ProdutoDto dto) {

        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/produtos/{codigo}")
    public ResponseEntity excluirPorId(@PathVariable("codigo") Integer codigo) {
        ProdutoDto dto = service.excluirPorId(codigo);
        return ResponseEntity.ok().body(dto);
    }


}
