package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.ProdutoLoteDTO;

import br.com.pi.projeto_RD.model.entity.ProdutoLoteEntity;
import br.com.pi.projeto_RD.repository.ProdutoLoteRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoLoteBO {

    @Autowired
    ProdutoLoteRepository produtoLoteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoLoteEntity parseToEntity (ProdutoLoteDTO dto, ProdutoLoteEntity entity){
        if(entity == null){
            entity = new ProdutoLoteEntity();
        }
        if(dto == null){
            return entity;
        }
        entity.setId_produto_lote(dto.getIdProdutoLote());
        entity.setDt_fabricacao(dto.getDtFabricacao());
        entity.setDs_validade(dto.getDtValidade());
        entity.setDs_lote(dto.getDsLote());
        entity.setVl_lote(dto.getVlLote());

        return entity;
    }

}
