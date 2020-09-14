package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProdutoFilialEstoqueRepository extends JpaRepository<ProdutoFilialEstoqueEntity, BigInteger>{

        @EntityGraph(value = "ProdutoFilialEstoqueEntity.filial.produto", type = EntityGraph.EntityGraphType.LOAD)
        List<ProdutoFilialEstoqueEntity> findAll();

        List<ProdutoFilialEstoqueEntity> findByFilialCdFilialAndProdutoCodigo(BigInteger cdFilial, BigInteger codigo);
        List<ProdutoFilialEstoqueEntity> findByFilialCdFilial(Long cdFilial);
        List<ProdutoFilialEstoqueEntity> findByFilialNmFilialContaining(String nmFilial);

}
