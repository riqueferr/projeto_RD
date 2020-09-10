package br.com.pi.projeto_RD.service;


import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoPageRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoPageRepository pageRepository;

    @Autowired
    private ProdutoBO produtoBO;

    @PersistenceContext
    private EntityManager manager;

    public List<ProdutoDto> listarTodas() {

        List<ProdutoDto> listDTO = new ArrayList<>();
        for (ProdutoEntity entity : repository.findAll()) {
            ProdutoDto dto = produtoBO.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public List<ProdutoDto> listarTodasPage(Integer page) {

        Pageable firstPageWithTwoElements = PageRequest.of(page, 2);

        Page<ProdutoEntity> produtoEntityPagentity = pageRepository.findAll(firstPageWithTwoElements);

        List<ProdutoDto> listDTO = new ArrayList<>();
        for (ProdutoEntity entity : produtoEntityPagentity) {
            ProdutoDto dto = produtoBO.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public ProdutoDto buscarPorId(Integer codigo) {
        return produtoBO.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoEntity> buscarNfPornmProduto(String Nm_Fantasia) {
        return manager.createNamedQuery("buscarNfPornmProduto", ProdutoEntity.class).setParameter("NM_FANTASIA", Nm_Fantasia).getResultList();
    }

    public ProdutoEntity inserir(ProdutoDto dto) throws Exception {
        ProdutoEntity entity = produtoBO.parseToEntity(dto, null);
        if (entity.getNm_fantasia() != null)
            repository.save(entity);
        return entity;
    }

    public void atualizar(ProdutoDto dto) throws Exception {
        ProdutoEntity entity = repository.getOne(dto.getCodigo());
        if (entity != null) {
            entity = produtoBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public ProdutoDto excluirPorId(Integer codigo) {
        ProdutoEntity entity = repository.getOne(codigo);
        ProdutoDto dto = new ProdutoDto();

        if (entity != null) {
            dto = produtoBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }


}
