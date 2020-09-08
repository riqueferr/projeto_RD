package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.dto.DocumentoFiscalDTO;
import br.com.pi.projeto_RD.model.dto.PagamentoDocDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, Long> {

    List<DocumentoFiscalEntity> findByOperacaoDsOperacao(String operacao);
    List<DocumentoFiscalEntity> findByMotivoDsMotivo(String motivo);
    List<DocumentoFiscalEntity> findByOperacaoDsOperacaoAndFilialNmFilial(String operacao, String filial);

}
