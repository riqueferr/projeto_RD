package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.StatusProdutoDTO;
import br.com.pi.projeto_RD.model.dto.SubCategoriaDTO;
import br.com.pi.projeto_RD.repository.CategoriaRepository;
import br.com.pi.projeto_RD.repository.StatusRepository;
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
public class StatusController {

    @Autowired
    StatusRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/status")
    public ResponseEntity<Object> listarTodas() {

        Map<Integer, StatusProdutoDTO> map = new HashMap<>();
        Query query = manager.createNativeQuery("SELECT S.ID_STATUS_PRODUTO, S.DS_STATUS_PRODUTO FROM pi_java.TB_STATUS_PRODUTO S");

        List<Object[]> listEntity = query.getResultList();
        for (Object[] produto : listEntity) {
            Integer codigo = ((BigInteger) produto[0]).intValue();
            StatusProdutoDTO dto = null;
            if (!map.containsKey(codigo)) {
                dto = new StatusProdutoDTO();

                dto.setIdStatusProduto((BigInteger) produto[0]);
                dto.setDsStatusProduto((String) produto[1]);
            }
            map.put(dto.getIdStatusProduto().intValue(), dto);
        }
        return ResponseEntity.ok().body(map.values().stream().collect(Collectors.toList()));
    }

}
