package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.SubCategoriaDTO;
import br.com.pi.projeto_RD.model.dto.TipoProdutoDTO;
import br.com.pi.projeto_RD.repository.StatusRepository;
import br.com.pi.projeto_RD.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TipoProdutoController {

    @Autowired
    TipoProdutoRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/tipoproduto")
    public ResponseEntity<Object> listarTodas() {

        Map<Integer, TipoProdutoDTO> map = new HashMap<>();
        Query query = manager.createNativeQuery("SELECT T.ID_TIPO_PRODUTO, T.DS_TIPO_PRODUTO FROM TB_TIPO_PRODUTO T");

        List<Object[]> listEntity = query.getResultList();
        for (Object[] produto : listEntity) {
            Integer codigo = ((BigInteger) produto[0]).intValue();
            TipoProdutoDTO dto = null;
            if (!map.containsKey(codigo)) {
                dto = new TipoProdutoDTO();

                dto.setIdTipoProduto((BigInteger) produto[0]);
                dto.setDsTipoProduto((String) produto[1]);
            }
            map.put(dto.getIdTipoProduto().intValue(), dto);
        }
        return ResponseEntity.ok().body(map.values().stream().collect(Collectors.toList()));
    }

}
