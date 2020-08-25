package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.FilialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilialController {

    @Autowired
    FilialRepository repository;

    @Autowired
    private FilialService service;


    //LISTAR TODOS
    @GetMapping("/filial")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }


    //LISTAR POR ID
    @GetMapping("/filial/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    //ATUALIZAR
    @PutMapping("/filial")
    public ResponseEntity atualizar(@RequestBody FilialDTO dto) throws Exception {
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    //INSERIR
    @PostMapping("/filial")
    public ResponseEntity<Object> salvarProdutos(@RequestBody FilialDTO dto) {
        ResultData resultData = null;
        if (dto.getNm_filial() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Nome não informado!");
        else if (dto.getNr_cpnj() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "CNPJ não informado!");

        if (resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                service.inserir(dto);
                resultData = new ResultData<ProdutoEntity>(HttpStatus.OK.value(), "Filial registrada com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar Filial", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
            }
        }
    }


}
