package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.RelatorioProdutoDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.RelatorioProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class RelatorioProdutoService {

    @Autowired
    private RelatorioProdutoBO bo;

    @Autowired
    private ProdutoRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public List<RelatorioProdutoDTO> listarTodas() {
        List<ProdutoEntity> listEntity = repository.findAll();
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : repository.findAll()) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public List<RelatorioProdutoDTO> buscarNfPornmProduto(String Nm_Fantasia) {

        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPornmProduto", ProdutoEntity.class).setParameter("NM_FANTASIA", Nm_Fantasia).getResultList();;
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : listEntity) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public List<RelatorioProdutoDTO> buscarNfPoridStatusProduto(Long idStatusProduto) {

        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPoridStatusProduto", ProdutoEntity.class).setParameter("ID_STATUS_PRODUTO", idStatusProduto).getResultList();
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : listEntity) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public RelatorioProdutoDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoEntity> buscarNfPordsStatusProduto(String dsStatusProduto) {
        return manager.createNamedQuery("buscarNfPordsStatusProduto", ProdutoEntity.class).setParameter("DS_STATUS_PRODUTO", dsStatusProduto).getResultList();
    }

}
