package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.dto.DocumentoFiscalDTO;
import br.com.pi.projeto_RD.model.dto.PagamentoDocDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscalEntity, BigInteger> {

    @EntityGraph(value = "documentosfindall", type = EntityGraph.EntityGraphType.LOAD)
    List<DocumentoFiscalEntity> findAll();

    List<DocumentoFiscalEntity> findByOperacaoDsOperacao(String operacao);
    List<DocumentoFiscalEntity> findByMotivoDsMotivo(String motivo);
    List<DocumentoFiscalEntity> findByOperacaoDsOperacaoAndFilialNmFilial(String operacao, String filial);
    List<DocumentoFiscalEntity> findByOperacaoDsOperacaoAndDestinoNmFilialContaining(String operacao, String filial);

}
