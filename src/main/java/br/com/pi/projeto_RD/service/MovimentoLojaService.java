package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.MovimentoLojaDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.MovimentoLojaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
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

    public List<DocumentoFiscalEntity> buscarPagamento(Long idDocumento){

        return manager.createNamedQuery("buscarTiposPagamento", DocumentoFiscalEntity.class).setParameter("ID_DOCUMENTO_FISCAL", idDocumento).getResultList();

    }

    public List<DocumentoFiscalEntity> buscarData(Date dtEntrada){
        return manager.createNamedQuery("buscarNfPorDataEntrada", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).getResultList();
    }

}
