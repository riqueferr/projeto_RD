package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.EntradaDTO;
import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.repository.EntradaRepository;
import br.com.pi.projeto_RD.service.EntradaService;
import br.com.pi.projeto_RD.service.bo.EntradaBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaController {


    @Autowired
    EntradaBO entradaBO;

    @Autowired
    EntradaService service;


    //LISTAR TODOS
    @GetMapping("/entrada")
    public ResponseEntity buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //LISTAR UM
    @GetMapping("/entrada/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }


//    //REGISTRAR
//    @PostMapping("/entrada")
//    public ResponseEntity inserir(@RequestBody EntradaDTO dto){
//        entradaService.inserir(dto);
//
//        return ResponseEntity.ok().body(dto);
//    }

    //EXCLUIR
    @DeleteMapping("/entrada/{codigo}")
    public ResponseEntity excluirPorId(@PathVariable("codigo") Integer codigo) {
        EntradaDTO dto = service.excluirPorId(codigo);
        return ResponseEntity.ok().body(dto);
    }


}
