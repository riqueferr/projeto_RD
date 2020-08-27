package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.service.DFTransferenciaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferenciaController {

    @Autowired
    private DFTransferenciaService service;

    @GetMapping("/transferencia")
    @ApiOperation(value = "Listar todas notas fiscais por transferencia")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @PostMapping("/transferencia")
    @ApiOperation(value = "Salvar notas fiscais por transferencia")
    public ResponseEntity<Object> inserir(@RequestBody DFTransferenciaDTO dfTransferenciaDTO) throws Exception {
        service.inserir(dfTransferenciaDTO);
        return ResponseEntity.ok().body(dfTransferenciaDTO);
    }

}
