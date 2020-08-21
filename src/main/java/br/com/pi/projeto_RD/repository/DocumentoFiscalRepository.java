package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, Long> {
}
