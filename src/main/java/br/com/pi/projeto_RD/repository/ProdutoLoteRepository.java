package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.ProdutoLoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoLoteRepository extends JpaRepository<ProdutoLoteEntity, Integer> {

}
