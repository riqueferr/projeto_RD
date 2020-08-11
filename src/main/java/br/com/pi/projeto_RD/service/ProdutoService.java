package br.com.pi.projeto_RD.service;



import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoBO produtoBO;

    public List<ProdutoDto> buscarTodas() {

        List<ProdutoDto> listDTO = new ArrayList<>();
        for (ProdutoEntity entity : repository.findAll()) {
            ProdutoDto dto = produtoBO.parseToDTO(entity);
            listDTO.add(dto);
        }
        return listDTO;
    }

    public ProdutoDto buscarPorId(Integer codigo){
        return produtoBO.parseToDTO(repository.getOne(codigo));
    }

    public void inserir(ProdutoDto dto) {
        ProdutoEntity entity = produtoBO.parseToEntity(dto, null);
        if(entity.getNm_fantasia() != null)
            repository.save(entity);
    }

    public void atualizar(ProdutoDto dto) {

        ProdutoEntity entity = repository.getOne(dto.getCodigo());
        if(entity != null){
            entity = produtoBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public ProdutoDto excluirPorId(Integer codigo){
        ProdutoEntity entity = repository.getOne(codigo);
        ProdutoDto dto = new ProdutoDto();

        if(entity != null) {
            dto = produtoBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }

//    public List<ProdutoEntity> buscarPorNome(String nome){
//        return repository.findByNome(nome);
//    }

}