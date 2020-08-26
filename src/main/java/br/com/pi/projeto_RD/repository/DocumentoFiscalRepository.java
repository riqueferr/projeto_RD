package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, Long> {

//    FilialEntity findByDestinoCdFilial(Long cdFilial);

    List<DocumentoFiscalEntity> findByOperacaoDsOperacao(String operacao);

}
