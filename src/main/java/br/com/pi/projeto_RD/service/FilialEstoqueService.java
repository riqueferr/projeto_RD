package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilialEstoqueService {

    @Autowired
    private ProdutoFilialEstoqueBO pfBO;

    @Autowired
    private ProdutoFilialEstoqueRepository repository;

    public List<ProdutoFilialEstoqueDTO> buscarTodos() {
        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findAll();
        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();


        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public ProdutoFilialEstoqueDTO buscarPorId(Integer codigo) {
        return pfBO.parseToDTO(repository.getOne(codigo));
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
