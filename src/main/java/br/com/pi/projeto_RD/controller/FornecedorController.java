package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.repository.FornecedorRepository;
import br.com.pi.projeto_RD.service.FornecedorService;
import br.com.pi.projeto_RD.service.bo.FornecedorBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @Autowired
    private FornecedorRepository repository;

    @GetMapping("/fornecedores")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/fornecedores/{cd_fornecedor}")
    public ResponseEntity buscarPorId(@PathVariable("cd_fornecedor") Long cd_fornecedor){
        return ResponseEntity.ok().body(service.buscarPorId(cd_fornecedor));
    }

    @PutMapping("/fornecedores")
    @ApiOperation(value = "atualizar fornecedor selecionado")
    public ResponseEntity atualizar(@RequestBody FornecedorDTO dto) throws Exception {
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @ApiOperation(value = "Cadastrar fornecedor")
    @PostMapping("/fornecedores")
    public ResponseEntity inserir(@RequestBody FornecedorDTO dto){
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }

    @ApiOperation(value = "Excluir fornecedor")
    @DeleteMapping("/fornecedores/{cd_fornecedor}")
    public ResponseEntity excluirPorId(@PathVariable("cd_fornecedor") Long cd_fornecedor){
        FornecedorDTO dto = service.excluirPorId(cd_fornecedor);

        return ResponseEntity.ok().body(dto);
    }

}
