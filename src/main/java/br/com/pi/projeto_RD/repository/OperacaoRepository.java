package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OperacaoRepository extends JpaRepository<OperacaoEntity, BigInteger> {
}
