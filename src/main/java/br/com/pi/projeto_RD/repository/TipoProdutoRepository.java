package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TipoProdutoRepository extends JpaRepository<TipoProdutoEntity, BigInteger> {

}
