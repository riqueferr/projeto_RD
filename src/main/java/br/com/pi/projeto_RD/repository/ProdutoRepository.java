package br.com.pi.projeto_RD.repository;


import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, Integer> {
    // List<ProdutoEntity> findByNome(String nome); //select * from tb_loja where nome = ?
}
