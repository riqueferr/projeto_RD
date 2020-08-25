package br.com.pi.projeto_RD.controller;


import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.RelatorioProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @GetMapping("/relatorioproduto/status/{DS_STATUS_PRODUTO}")
    public ResponseEntity<Object> buscarNfPorDsStatus(@PathVariable("DS_STATUS_PRODUTO") Long DS_STATUS_PRODUTO){
        return ResponseEntity.ok().body(service.buscarNfPorDsStatus(DS_STATUS_PRODUTO));
    }

}
