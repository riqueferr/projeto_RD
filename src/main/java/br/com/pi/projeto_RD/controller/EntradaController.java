package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.service.bo.EntradaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntradaController {

    @Autowired
    EntradaBO entradaBO;

//    @GetMapping("/Entrada")
//    //@ApiOperation
//
//    public ResponseEntity buscarTodos(){
//        return ResponseEntity.ok().body(entradaBO.)
//    }


    @GetMapping("/Entrada/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo){
        return ResponseEntity.ok().body(buscarPorId(codigo));
    }

}
