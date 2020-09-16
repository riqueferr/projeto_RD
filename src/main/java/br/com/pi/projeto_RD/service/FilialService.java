package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.bo.FilialBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilialService {

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private FilialRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public List<FilialDTO> buscarTodos() {
        List<FilialEntity> filialEntity = repository.findAll();
        List<FilialDTO> filialDTO = new ArrayList<>();


        for (FilialEntity entity : filialEntity) {
            FilialDTO dto = filialBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public FilialDTO buscarPorId(BigInteger codigo) {
        return filialBO.parseToDTO(repository.getOne(codigo));
    }

    public List<FilialEntity> buscarNfPornmFilial(String nmFilial) {
        return manager.createNamedQuery("buscarNfPornmFilial", FilialEntity.class).setParameter("NM_FILIAL", nmFilial).getResultList();
    }

    public List<FilialEntity> buscarNfPorCD(String nmFilial) {
        return manager.createNamedQuery("buscarNfPorCD", FilialEntity.class).setParameter("NM_BANDEIRA", nmFilial).getResultList();
    }

    public void atualizar(FilialDTO dto) throws Exception {
        FilialEntity entity = repository.getOne(dto.getCd_filial());
        if (entity != null) {
            entity = filialBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public FilialEntity inserir(FilialDTO dto) throws Exception {
        FilialEntity entity = filialBO.parseToEntity(dto, null);
        if (entity.getNmFilial() != null)
            repository.save(entity);
        return entity;
    }


}
