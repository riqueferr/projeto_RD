package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
