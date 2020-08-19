package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.EntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<EntradaEntity, Integer> {
}
