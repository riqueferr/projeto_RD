package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoFilialEstoqueBO {

    @Autowired
    private ProdutoFilialEstoqueRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private ProdutoFilialEstoqueEntity ParseToEntity (ProdutoFilialEstoqueDTO dto, ProdutoFilialEstoqueEntity entity){
        if(entity == null){
            entity = new ProdutoFilialEstoqueEntity();
        }
        if(dto == null){
            return entity;
        }
        entity.setFk_id_filial(dto.getFk_filial());
        entity.setProduto(produtoRepository.getOne(dto.getFk_produto().getCodigo()));
        entity.setQt_base(dto.getQt_base());
        entity.setQt_estoque(dto.getQt_estoque());
        entity.setQt_empenho(dto.getQt_empenho());

        return entity;

    }
}
