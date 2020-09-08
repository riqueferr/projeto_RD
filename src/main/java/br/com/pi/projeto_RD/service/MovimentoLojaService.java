package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.MovimentoLojaDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.MovimentoLojaBO;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimentoLojaService {

    @Autowired
    private MovimentoLojaBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private EntityManager manager;

    public List<MovimentoLojaDTO> buscarTodos() {
        List<DocumentoFiscalEntity> dfEntity = repository.findAll();
        List<MovimentoLojaDTO> movimentoDTO = new ArrayList<>();


        for (DocumentoFiscalEntity entity : dfEntity) {
            MovimentoLojaDTO dto = bo.parseToDTO(entity);
            movimentoDTO.add(dto);
        }
        return movimentoDTO;
    }

    public List<PagamentoDocEntity> buscarPagamento(Date dtEntrada){


        return manager.createNamedQuery("buscarTiposPagamento", PagamentoDocEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).getResultList();

    }

    public List<DocumentoFiscalEntity> buscarData(Date dtEntrada){
        return manager.createNamedQuery("buscarNfPorDataEntrada", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).getResultList();
    }

    public List<PagamentoDocEntity> buscarPagamentoDinheiro(){

        return manager.createNamedQuery("buscarTipoDinheiro", PagamentoDocEntity.class).getResultList();
    }

    public List<PagamentoDocEntity> buscarPagamentoCheque(){

        return manager.createNamedQuery("buscarTipoCheque", PagamentoDocEntity.class).getResultList();
    }

    public List<MovimentoLojaDTO> buscarTeste(Date dtEntrada, Long filial){

        List<DocumentoFiscalEntity> list = manager.createNamedQuery("filtrarDataeFilial", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial).getResultList();
        List<MovimentoLojaDTO> dtoList = new ArrayList<>();
        for (DocumentoFiscalEntity entity : list){
            dtoList.add(new MovimentoLojaDTO(entity.getIdDocumento(),entity.getDtEntrada(), entity.getVlDocumentoFiscal(), entity.getOperacao(),entity.getFilial()));
        }
        return dtoList;
    }

    public Double somarDinheiro(Date dtEntrada, Long filial){
        Query query = (Query) manager.createQuery("Select sum(p.vlPagamento) from DocumentoFiscalEntity n  JOIN n.pagamento p where p.tipoPagamento.idTipoPagamento = 4 AND n.dtEntrada = :DT_ENTRADA AND n.filial.cdFilial = :FILIAL", Double.class);
        query.setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial);

        return (Double) query.getSingleResult();
    }

    public Double somarCheque(Date dtEntrada, Long filial){
        Query query = (Query) manager.createQuery("Select sum(p.vlPagamento) from DocumentoFiscalEntity n  JOIN n.pagamento p where p.tipoPagamento.idTipoPagamento = 5 AND n.dtEntrada = :DT_ENTRADA AND n.filial.cdFilial = :FILIAL", Double.class);
        query.setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial);

        return (Double) query.getSingleResult();
    }



}
