package br.com.pi.projeto_RD.controller;

import br.com.pi.projeto_RD.model.dto.FornecedorProdutoDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.SubCategoriaDTO;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.SubCategoriaEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import br.com.pi.projeto_RD.repository.SubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SubCategoriaController {

    @Autowired
    SubCategoriaRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/subcategorias")
    public ResponseEntity<Object> listarTodas() {

        Map<Integer, SubCategoriaDTO> map = new HashMap<>();
        Query query = manager.createNativeQuery("SELECT S.ID_SUB_CATEGORIA, S.DS_SUB_CATEGORIA FROM TB_SUB_CATEGORIA_PRODUTO S");

        List<Object[]> listEntity = query.getResultList();
        for (Object[] produto : listEntity) {
            Integer codigo = ((BigInteger) produto[0]).intValue();
            SubCategoriaDTO dto = null;
            if (!map.containsKey(codigo)) {
                dto = new SubCategoriaDTO();

                dto.setIdSubCategoria((BigInteger) produto[0]);
                dto.setDsSubCategoria((String) produto[1]);
            }
            map.put(dto.getIdSubCategoria().intValue(), dto);
        }
        return ResponseEntity.ok().body(map.values().stream().collect(Collectors.toList()));
    }

}

