package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoFilialEstoqueRepository extends JpaRepository<ProdutoFilialEstoqueEntity, Integer>{

        List<ProdutoFilialEstoqueEntity> findByFilialCdFilialAndProdutoCodigo(Long cdFilial, Integer codigo);
        List<ProdutoFilialEstoqueEntity> findByFilialCdFilial(Long cdFilial);
        List<ProdutoFilialEstoqueEntity> findByFilialNmFilial(String nmFilial);

}
