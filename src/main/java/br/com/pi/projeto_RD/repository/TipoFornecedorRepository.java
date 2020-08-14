package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.TipoFornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TipoFornecedorRepository extends JpaRepository<TipoFornecedorEntity, Long> {
}
