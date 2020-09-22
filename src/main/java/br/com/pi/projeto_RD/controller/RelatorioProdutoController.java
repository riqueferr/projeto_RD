package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.RelatorioProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class RelatorioProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private RelatorioProdutoService service;

    @GetMapping("/relatorioproduto")
    @ApiOperation(value = "Listar relatório dos produtos")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.listarTodas());
    }

    @GetMapping("/relatorioproduto/{codigo}")
    @ApiOperation(value = "Listar todas os produtos por id")
    public ResponseEntity buscarPorId(@PathVariable("codigo") BigInteger codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @GetMapping("/relatorioproduto/status/{ID_STATUS_PRODUTO}")
    @ApiOperation(value = "Listar todas os produtos por ID STATUS")
    public ResponseEntity<Object> buscarNfPoridStatusProduto(@PathVariable("ID_STATUS_PRODUTO") BigInteger idStatusProduto) {
        return ResponseEntity.ok().body(service.buscarNfPoridStatusProduto(idStatusProduto));
    }

//    @GetMapping("/relatorioproduto/statusProduto/{DS_STATUS_PRODUTO}")
//    @ApiOperation(value = "Listar todas os produtos por DS STATUS")
//    public ResponseEntity<Object> buscarNfPordsStatusProduto(@PathVariable("DS_STATUS_PRODUTO") String dsStatusProduto) {
//        return ResponseEntity.ok().body(service.buscarNfPordsStatusProduto(dsStatusProduto));
//    }

    @GetMapping("/relatorioproduto/nmproduto/{Nm_Fantasia}")
    @ApiOperation(value = "Listar todas os produtos por NOME PRODUTO")
    public ResponseEntity<Object> buscarNfPornmProduto(@PathVariable("Nm_Fantasia") String Nm_Fantasia) {
        return ResponseEntity.ok().body(service.buscarNfPornmProduto(Nm_Fantasia));
    }

}
