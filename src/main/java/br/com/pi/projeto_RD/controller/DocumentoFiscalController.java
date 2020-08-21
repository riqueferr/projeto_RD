package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentoFiscalController {

    @Autowired
    DocumentoFiscalRepository repository;

    @GetMapping("/documentofiscal")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
