package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.service.DFTransferenciaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class TransferenciaController {

    @Autowired
    private DFTransferenciaService service;

    @GetMapping("/transferencia")
    @ApiOperation(value = "Listar todas notas fiscais por transferencia")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //BUSCAR POR ID
    @GetMapping("/transferencia/{codigo}")
    @ApiOperation(value = "Buscar documentos fiscais por ID transferencia")
    public ResponseEntity buscarPorId(@PathVariable("codigo") BigInteger codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    //BUSCAR POR FILIAL
    @GetMapping("/transferencia/filial/{filial}")
    public ResponseEntity buscarPorFilial(@PathVariable("filial") String filial) {
        return ResponseEntity.ok().body(service.buscarPorFilial(filial));
    }

    @PostMapping("/transferencia")
    @ApiOperation(value = "Salvar notas fiscais por transferencia")
    public ResponseEntity<Object> inserir(@RequestBody DFTransferenciaDTO dfTransferenciaDTO) throws Exception {
        service.inserir(dfTransferenciaDTO);
        return ResponseEntity.ok().body(dfTransferenciaDTO);
    }

}
