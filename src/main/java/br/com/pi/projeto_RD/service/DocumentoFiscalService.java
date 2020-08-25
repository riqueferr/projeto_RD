package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DocumentoFiscalDTO;
import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.DocumentoFiscalBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoFiscalService {

    @Autowired
    private DocumentoFiscalBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public List<DocumentoFiscalDTO> buscarTodos() {
        List<DocumentoFiscalEntity> dfEntity = repository.findAll();
        List<DocumentoFiscalDTO> dfDTO = new ArrayList<>();


        for (DocumentoFiscalEntity entity : dfEntity) {
            DocumentoFiscalDTO dto = bo.parseToDTO(entity);
            dfDTO.add(dto);
        }
        return dfDTO;
    }

    public DocumentoFiscalDTO buscarPorId(Long codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<DocumentoFiscalEntity> buscarNfPorFilial(String filial) {
        return manager.createNamedQuery("buscarNfPorFilial", DocumentoFiscalEntity.class).setParameter("NM_FILIAL", filial).getResultList();
    }

    public List<DocumentoFiscalEntity> buscarNfPorDataEntrada(String dtEntrada) {
        return manager.createNamedQuery("buscarNfPorDataEntrada", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada).getResultList();
    }

}
