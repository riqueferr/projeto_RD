package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.FornecedorPageRepository;
import br.com.pi.projeto_RD.repository.FornecedorRepository;
import br.com.pi.projeto_RD.repository.TipoFornecedorRepository;
import br.com.pi.projeto_RD.service.bo.FornecedorBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FornecedorService {


    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorPageRepository pageRepository;

    @Autowired
    private TipoFornecedorRepository tipoFornecedorRepository;

    @Autowired
    private FornecedorBO fornecedorBO;

    @PersistenceContext
    private EntityManager manager;


    public List<FornecedorDTO> buscarTodos(){

        List<FornecedorEntity> fornecedorEntity = repository.findAll();
        List<FornecedorDTO> fornecedorDTO = new ArrayList<>();

        for (FornecedorEntity entity : fornecedorEntity){
            FornecedorDTO dto = fornecedorBO.parseToDTO(entity);
            fornecedorDTO.add(dto);
        }
        return fornecedorDTO;
    }

    public List<FornecedorDTO> buscarPages(Integer page){

        Pageable firstPageWithTwoElements = PageRequest.of(page, 5);

        Page<FornecedorEntity> fornecedorEntity = pageRepository.findAll(firstPageWithTwoElements);

        List<FornecedorDTO> fornecedorDTO = new ArrayList<>();
        for (FornecedorEntity entity : fornecedorEntity){
            FornecedorDTO dto = fornecedorBO.parseToDTO(entity);
            fornecedorDTO.add(dto);
        }
        return fornecedorDTO;
    }

    public FornecedorDTO buscarPorId(BigInteger cd_fornecedor){
        return fornecedorBO.parseToDTO(repository.getOne(cd_fornecedor));
    }

    public List<FornecedorDTO> buscarPorNomeFornecedor(String nomeFornecedor){

        List<FornecedorEntity> fornecedorEntity = manager.createNamedQuery("buscarNfPornmFornecedor", FornecedorEntity.class).setParameter("nm_razao_social", nomeFornecedor).getResultList();;
        List<FornecedorDTO> fornecedorDTO = new ArrayList<>();

        for (FornecedorEntity entity : fornecedorEntity){
            FornecedorDTO dto = fornecedorBO.parseToDTO(entity);
            fornecedorDTO.add(dto);
        }
        return fornecedorDTO;
    }

    public void atualizar(FornecedorDTO dto) {
        FornecedorEntity entity = repository.getOne(dto.getCd_fornecedor());
        if(entity != null){
            entity = fornecedorBO.parseToEntity(dto, entity);
            repository.save(entity);
        }

    }

    public void inserir(FornecedorDTO dto) {
        FornecedorEntity entity = fornecedorBO.parseToEntity(dto, null);
        if(entity.getNm_razao_social() != null)
            repository.save(entity);
    }

    public FornecedorDTO excluirPorId(BigInteger cd_fornecedor){
        FornecedorEntity entity = repository.getOne(cd_fornecedor);
        FornecedorDTO dto = new FornecedorDTO();

        if(entity != null) {
            dto = fornecedorBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }


}
