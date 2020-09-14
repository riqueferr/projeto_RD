package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.model.dto.DocumentoFiscalDTO;
import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.DocumentoFiscalService;
import br.com.pi.projeto_RD.service.FilialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class DocumentoFiscalController {

    @Autowired
    DocumentoFiscalRepository repository;

    @Autowired
    private DocumentoFiscalService service;

    //LISTAR TODOS DF
    @GetMapping("/documentofiscal")
    @ApiOperation(value = "Listar documentos fiscais por ID")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //LISTAR POR ID
    @GetMapping("/documentofiscal/{codigo}")
    @ApiOperation(value = "Listar documentos fiscais por ID")
    public ResponseEntity buscarPorId(@PathVariable("codigo") BigInteger codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    //LISTAR POR NOME DA FILIAL
    @GetMapping("/documentofiscal/filial/{filial}")
    @ApiOperation(value = "Listar documentos fiscais por nome filial")
    public ResponseEntity<Object> buscarNfPorFilial(@PathVariable("filial") String filial) {
        return ResponseEntity.ok().body(service.buscarNfPorFilial(filial));
    }


    //LISTAR POR MOTIVO TROCA
    @GetMapping("/documentofiscal/motivo/{dsmotivo}")
    @ApiOperation(value = "Listar documentos fiscais por nome do MOTIVO")
    public ResponseEntity buscarPorMotivo(@PathVariable("dsmotivo") String dsMotivo) {
        return ResponseEntity.ok().body(service.buscarPorMotivo(dsMotivo));
    }

    //LISTAR TODOS DF
    @GetMapping("/documentofiscal/total")
    public ResponseEntity<Object> filialMotivo() {
        return ResponseEntity.ok().body(service.filialMotivo());
    }

    //LISTAR POR DATA ENTRADA
    @GetMapping("/documentofiscal/data/{dtentrada}")
    @ApiOperation(value = "Buscar documentos fiscais por Data")
    public ResponseEntity<Object> buscarNfPorDataEntrada(@PathVariable("dtentrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dtEntrada) {
        return ResponseEntity.ok().body(service.buscarNfPorDataEntrada(dtEntrada));
    }

    //EXCLUIR POR ID
    @DeleteMapping("/documentofiscal/{codigo}")
    @ApiOperation(value = "Excluir documento fiscal por ID")
    public ResponseEntity excluirPorId(@PathVariable("codigo") BigInteger codigo) {
        DocumentoFiscalDTO dto = service.excluirPorId(codigo);
        return ResponseEntity.ok().body(dto);
    }


}
