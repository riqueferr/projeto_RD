package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilialEstoqueService {

    @Autowired
    private ProdutoFilialEstoqueBO pfBO;

    @Autowired
    private ProdutoFilialEstoqueRepository repository;


    @PersistenceContext
    private EntityManager manager;

    public List<ProdutoFilialEstoqueDTO> buscarTodos() {
        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findAll();
        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();


        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public ProdutoFilialEstoqueDTO buscarPorId(BigInteger codigo) {
        return pfBO.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoFilialEstoqueDTO> buscarCdFilial(Long cdFilial) {
        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findByFilialCdFilial(cdFilial);
        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();
        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public List<ProdutoFilialEstoqueDTO> buscarNmFilial(String nmFilial) {
        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findByFilialNmFilialContaining(nmFilial);
        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();
        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public ProdutoFilialEstoqueEntity inserir(ProdutoFilialEstoqueDTO dto) throws Exception {
        ProdutoFilialEstoqueEntity entity = pfBO.parseToEntity(dto, null);

        if (entity.getQt_estoque() != null)
            repository.save(entity);
        return entity;
    }

    public void atualizar(ProdutoFilialEstoqueDTO dto) throws Exception {
        ProdutoFilialEstoqueEntity entity = repository.getOne(dto.getCdEstoque());
        if (entity != null) {
            entity = pfBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

}
