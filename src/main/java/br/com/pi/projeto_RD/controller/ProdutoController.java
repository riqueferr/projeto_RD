package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    private ProdutoService service;


    @GetMapping("/produtos")
    @ApiOperation(value = "Listar todas os produtos")
    public ResponseEntity buscarTodas() {
        return ResponseEntity.ok().body(service.listarTodas());
    }

    @GetMapping("/produtos/{codigo}")
    @ApiOperation(value = "Listar todas os produtos por id")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo) {
        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @PutMapping("/produtos")
    @ApiOperation(value = "Atualizar produto selecionado")
    public ResponseEntity atualizar(@RequestBody ProdutoDto dto) throws Exception {
        service.atualizar(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/produtos/{codigo}")
    @ApiOperation(value = "Excluir produto por ID")
    public ResponseEntity excluirPorId(@PathVariable("codigo") Integer codigo) {
        ProdutoDto dto = service.excluirPorId(codigo);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "Salvar produtos")
    public ResponseEntity<Object> salvarProdutos(@RequestBody ProdutoDto produtoDto) {
        ResultData resultData = null;
        if (produtoDto.getNm_fantasia() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Nome fantasia não informado!");
        else if (produtoDto.getCategoria().getDsCategoria() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Código categoria não informado!");

        if (resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                service.inserir(produtoDto);
                resultData = new ResultData<ProdutoEntity>(HttpStatus.OK.value(), "Produto registrada com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar Produto", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
            }
        }
    }


}
