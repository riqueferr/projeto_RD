package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.*;
import br.com.pi.projeto_RD.repository.FilialRepository;
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

    public FilialDTO parseToDTO(FilialEntity f) {
        FilialDTO dto = new FilialDTO();

        if (f == null)
            return dto;

        dto.setCd_filial(f.getCd_filial());
        dto.setNm_filial(f.getNm_filial());
        dto.setNr_cpnj(f.getNr_cnpj());
        dto.setNr_telefone(f.getNr_telefone());

        List<ProdutoFilialDTO> produto = new ArrayList<>();

        for (ProdutoFilialEstoqueEntity item : f.getProdutos()) {
            ProdutoFilialDTO eDTO = new ProdutoFilialDTO();

            eDTO.setCodigo(item.getProduto().getCodigo());
            eDTO.setNm_fantasia(item.getProduto().getNm_fantasia());
            eDTO.setStatusProduto(item.getProduto().getStatus().getDsStatusProduto());
            eDTO.setCategoria(item.getProduto().getCategoria().getDsCategoria());
            eDTO.setTipoProduto(item.getProduto().getTipo_produto().getDsTipoProduto());
            eDTO.setVl_unidade(item.getProduto().getVl_unidade());
            eDTO.setQuantidade(item.getQt_estoque());
            eDTO.setQt_empenho(item.getQt_empenho());
            eDTO.setQt_base(item.getQt_base());

            produto.add(eDTO);
        }
        dto.setProduto(produto);
        return dto;
    }

//    public FilialEntity parseToEntity(FilialDTO dto, FilialEntity fEntity) throws Exception {
//        if (fEntity == null)
//            fEntity = new FilialEntity();
//
//        if (dto == null)
//            return fEntity;
//
//        fEntity.setCd_filial(dto.getCd_filial());
//        fEntity.setNm_filial(dto.getNm_filial());
//        fEntity.setNr_cnpj(dto.getNr_cpnj());
//        fEntity.setNr_telefone(dto.getNr_telefone());
//
//
//        List<ProdutoEntity> itemsEntity = new ArrayList<>();
//
//        for (ProdutoFilialDTO itemDTO : dto.getProduto()) {
//            ProdutoEntity Entity = new ProdutoEntity();
//
//            Entity.setCodigo(itemDTO.getCodigo());
//            Entity.setNm_fantasia(itemDTO.getNm_fantasia());
//            Entity.setStatus(itemDTO.getNm_fantasia());
//
//
//            itemsEntity.add(fEntity);
//        }
//
//        pEntity.setFornecedor(itemsEntity);
//
//        return pEntity;
//    }

}
