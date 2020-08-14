package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusProdutoEntity, Long> {

}
