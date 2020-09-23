package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.service.DFEntradaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class EntradaController {

    @Autowired
    private DFEntradaService service;

    //BUSCAR TODOS
    @GetMapping("/entrada")
    @ApiOperation(value = "Buscar documentos fiscais por Entrada")
    public ResponseEntity<Object> buscarTodas() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    //BUSCAR POR ID
    @GetMapping("/entrada/{codigo}")
    @ApiOperation(value = "Buscar documentos fiscais por ID Entrada")
    public ResponseEntity buscarPorId(@PathVariable("codigo") BigInteger codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    //BUSCAR POR FILIAL
    @GetMapping("/entrada/filial/{filial}")
    public ResponseEntity buscarPorFilial(@PathVariable("filial") String filial) {
        return ResponseEntity.ok().body(service.buscarPorFilial(filial));
    }

    //ATUALIZAR
//    @PutMapping("/entrada")
//    @ApiOperation(value = "Atualizar documentos fiscais por ID Entrada")
//    public ResponseEntity atualizar(@RequestBody DFEntradaDTO dto) throws Exception {
//        service.atualizar(dto);
//        return ResponseEntity.ok().body(dto);
//    }

    //INSERIR ENTRADA PRODUTO
    @PostMapping("/entrada")
    public ResponseEntity<Object> salvarProdutos(@RequestBody DFEntradaDTO dfEntradaDTO) {
        ResultData resultData = null;
        if (dfEntradaDTO.getVlDocumentoFiscal() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Valor não informado!");
        else if (dfEntradaDTO.getOperacao().getCdOperacao() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Operação não informado!");

        if (resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                service.inserir(dfEntradaDTO);
                resultData = new ResultData<ProdutoEntity>(HttpStatus.OK.value(), "DF registrada com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar DF", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
            }
        }
    }

}
