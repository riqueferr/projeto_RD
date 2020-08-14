package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
}
