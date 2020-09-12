package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, BigInteger> {

    @EntityGraph(value = "FornecedorEntity.enderecos", type = EntityGraph.EntityGraphType.LOAD)
    List<FornecedorEntity> findAll();

}
