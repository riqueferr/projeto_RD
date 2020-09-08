package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.DocumentoFiscalDTO;
import br.com.pi.projeto_RD.model.dto.MovimentoLojaDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.MovimentoLojaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
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

    public List<MovimentoLojaDTO> buscarTeste(){

//      List<DocumentoFiscalEntity> teste = manager.createNamedQuery("testePagamento", DocumentoFiscalEntity.class).getResultList();
//
//      List<DocumentoFiscalDTO> dto = new ArrayList<>();
//      for ()

        TypedQuery<MovimentoLojaDTO> query = manager.createQuery("Select NEW MovimentoLojaDTO(n.idDocumento) from DocumentoFiscalEntity n WHERE n.operacao.cdOperacao = 4",MovimentoLojaDTO.class);
        List<MovimentoLojaDTO> list = query.getResultList();
//        List<MovimentoLojaDTO> dtoList = new ArrayList<>();
//        for (MovimentoLojaDTO entity : list){
//            dtoList.add(new MovimentoLojaDTO(entity.getIdDocumento(), entity.getFilial(), entity.getDtEntrada(),entity.getPagamento(),entity.getVlDocumento(), entity.getOperacao()));
//        }


                return list;

    }



}
