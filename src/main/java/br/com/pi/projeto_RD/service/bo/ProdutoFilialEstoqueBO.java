package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoFilialEstoqueBO {

    @Autowired
    private ProdutoFilialEstoqueRepository repository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoFilialEstoqueDTO parseToDTO(ProdutoFilialEstoqueEntity f) {
        ProdutoFilialEstoqueDTO dto = new ProdutoFilialEstoqueDTO();

        if (f == null)
            return dto;

        dto.setCdEstoque(f.getCdEstoque());

        //FILIAL
        dto.setCdFilial(f.getFilial().getCdFilial());
        dto.setNmFilial(f.getFilial().getNmFilial());

        //PRODUTOS
        dto.setCdProduto(f.getProduto().getCodigo());
        dto.setNmProduto(f.getProduto().getNm_fantasia());
        dto.setSubCategoria(f.getProduto().getSubCategoria().getDsSubCategoria());

        //ESTOQUE
        dto.setQt_estoque(f.getQt_estoque());
        dto.setQt_empenho(f.getQt_empenho());
        dto.setQt_base(f.getQt_base());

        return dto;
    }


    public ProdutoFilialEstoqueEntity parseToEntity(ProdutoFilialEstoqueDTO dto, ProdutoFilialEstoqueEntity pEntity) throws Exception {
        if (pEntity == null)
            pEntity = new ProdutoFilialEstoqueEntity();

        if (dto == null)
            return pEntity;

        pEntity.setFilial(filialRepository.getOne(dto.getCdFilial()));
        pEntity.setProduto(produtoRepository.getOne(dto.getCdProduto()));
        pEntity.getProduto().setNm_fantasia(dto.getNmProduto());
        pEntity.setQt_estoque(dto.getQt_estoque());
        pEntity.setQt_base(dto.getQt_base());
        pEntity.setQt_empenho(dto.getQt_empenho());

        return pEntity;
    }

}
