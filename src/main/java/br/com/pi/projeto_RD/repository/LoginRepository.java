package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.OperadorEntity ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface LoginRepository extends JpaRepository<OperadorEntity, Long> {
    List<OperadorEntity> findByNrMatriculaAndPwOperador (BigInteger nrMatricula, String pwOperador);
}