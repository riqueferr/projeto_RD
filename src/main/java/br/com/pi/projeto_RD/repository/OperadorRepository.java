package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository  extends JpaRepository<OperadorEntity, Long> {


}
