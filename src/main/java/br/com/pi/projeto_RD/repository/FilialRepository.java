package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FilialRepository extends JpaRepository<FilialEntity, BigInteger> {

}
