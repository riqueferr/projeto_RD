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

import java.math.BigInteger;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @Autowired
    private FornecedorRepository repository;

    @GetMapping("/fornecedores")
    @ApiOperation(value = "Listar todos fornecedores")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/fornecedores/page/{pagina}")
    public ResponseEntity buscarPage(@PathVariable("pagina") Integer pagina){
        return ResponseEntity.ok().body(service.buscarPages(pagina));
    }

    @GetMapping("/fornecedores/{cd_fornecedor}")
    @ApiOperation(value = "Listar fornecedores por ID")
    public ResponseEntity buscarPorId(@PathVariable("cd_fornecedor") BigInteger cd_fornecedor){
        return ResponseEntity.ok().body(service.buscarPorId(cd_fornecedor));
    }

    @GetMapping("/fornecedores/nome/{nomeFornecedor}")
    @ApiOperation(value = "Listar fornecedores por Nome")
    public ResponseEntity buscarPorNomeFornecedor(@PathVariable("nomeFornecedor") String nomeFornecedor){
        return ResponseEntity.ok().body(service.buscarPorNomeFornecedor(nomeFornecedor));
    }

    @PutMapping("/fornecedores")
    @ApiOperation(value = "atualizar fornecedor selecionado")
    public ResponseEntity atualizar(@RequestBody FornecedorDTO dto) throws Exception {
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/fornecedores")
    @ApiOperation(value = "Cadastrar fornecedor")
    public ResponseEntity inserir(@RequestBody FornecedorDTO dto){
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/fornecedores/{cd_fornecedor}")
    @ApiOperation(value = "Excluir fornecedor")
    public ResponseEntity excluirPorId(@PathVariable("cd_fornecedor") BigInteger cd_fornecedor){
        FornecedorDTO dto = service.excluirPorId(cd_fornecedor);

        return ResponseEntity.ok().body(dto);
    }

}
