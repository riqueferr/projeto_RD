package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.*;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilialBO {

    @Autowired
    FilialRepository repository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoFilialEstoqueRepository estoqueRepository;

    public FilialDTO parseToDTO(FilialEntity f) {
        FilialDTO dto = new FilialDTO();

        if (f == null)
            return dto;

        dto.setCd_filial(f.getCdFilial());
        dto.setNm_filial(f.getNmFilial());
        dto.setNr_cpnj(f.getNr_cnpj());
        dto.setNr_telefone(f.getNr_telefone());

        List<ProdutoFilialDTO> produto = new ArrayList<>();

//        for (ProdutoFilialEstoqueEntity item : f.getProdutos()) {
//            ProdutoFilialDTO eDTO = new ProdutoFilialDTO();
//
//            eDTO.setCdEstoque(item.getProduto().getCodigo());
//            eDTO.setCdProduto(item.getProduto().getCodigo());
//            eDTO.setNm_fantasia(item.getProduto().getNm_fantasia());
//            eDTO.setStatusProduto(item.getProduto().getStatus().getDsStatusProduto());
//            eDTO.setSubCategoria(item.getProduto().getSubCategoria().getDsSubCategoria());
//            eDTO.setTipoProduto(item.getProduto().getTipo_produto().getDsTipoProduto());
//            eDTO.setVl_unidade(item.getProduto().getVl_unidade());
//
//            eDTO.setQuantidade(item.getQt_estoque());//////////////
//
////            eDTO.setQt_empenho(item.getQt_empenho());
////            eDTO.setQt_base(item.getQt_base());
//
//            produto.add(eDTO);
//        }
//        dto.setProduto(produto);
        return dto;
    }

    public FilialEntity parseToEntity(FilialDTO dto, FilialEntity fEntity) throws Exception {
        if (fEntity == null)
            fEntity = new FilialEntity();

        if (dto == null)
            return fEntity;

        fEntity.setCdFilial(dto.getCd_filial());
        fEntity.setNmFilial(dto.getNm_filial());
        fEntity.setNr_cnpj(dto.getNr_cpnj());
        fEntity.setNr_telefone(dto.getNr_telefone());


//        List<ProdutoFilialEstoqueEntity> itemsEntity = new ArrayList<>();
//
//        for (ProdutoFilialDTO itemDTO : dto.getProduto()) {
//            ProdutoFilialEstoqueEntity Entity = new ProdutoFilialEstoqueEntity();
//
//            Entity.setCdEstoque(itemDTO.getCdEstoque());
//            Entity.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
//
//
//            Entity.getProduto().setNm_fantasia((itemDTO.getNm_fantasia()));
//            Entity.getProduto().getStatus().setDsStatusProduto(itemDTO.getStatusProduto());
//            Entity.getProduto().setVl_unidade(itemDTO.getVl_unidade());
//            Entity.getProduto().getSubCategoria().setDsSubCategoria(itemDTO.getSubCategoria());
//            Entity.getProduto().getTipo_produto().setDsTipoProduto(itemDTO.getTipoProduto());
//            Entity.setQt_estoque(itemDTO.getQuantidade());
////            Entity.setQt_empenho(itemDTO.getQt_empenho());
////            Entity.setQt_base(itemDTO.getQt_base());
//
//
//            itemsEntity.add(Entity);
//        }
//
//        fEntity.setProdutos(itemsEntity);

        return fEntity;
    }

}
