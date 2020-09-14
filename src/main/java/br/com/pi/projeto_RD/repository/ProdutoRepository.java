package br.com.pi.projeto_RD.repository;


import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, BigInteger> {

    @EntityGraph(value = "produtosfindall", type = EntityGraph.EntityGraphType.LOAD)
    List<ProdutoEntity> findAll();

}
