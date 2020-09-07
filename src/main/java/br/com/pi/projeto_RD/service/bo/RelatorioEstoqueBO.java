package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialDTO;
import br.com.pi.projeto_RD.model.dto.RelatorioEstoqueDTO;
import br.com.pi.projeto_RD.model.dto.RelatorioEstoqueProdutoDTO;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelatorioEstoqueBO {

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public RelatorioEstoqueDTO parseToDTO(FilialEntity f) {
        RelatorioEstoqueDTO dto = new RelatorioEstoqueDTO();

        if (f == null)
            return dto;

        dto.setCd_filial(f.getCdFilial());
        dto.setNm_filial(f.getNmFilial());

//        List<RelatorioEstoqueProdutoDTO> produto = new ArrayList<>();
//
//        for (ProdutoFilialEstoqueEntity item : f.getProdutos()) {
//            RelatorioEstoqueProdutoDTO eDTO = new RelatorioEstoqueProdutoDTO();
//
//            eDTO.setCdProduto(item.getProduto().getCodigo());
//            eDTO.setNmProduto(item.getProduto().getNm_fantasia());
//            eDTO.setSubCategoria(item.getProduto().getSubCategoria().getDsSubCategoria());
//            eDTO.setTipoProduto(item.getProduto().getTipo_produto().getDsTipoProduto());
//            eDTO.setQuantidade(item.getQt_estoque());
//
//            produto.add(eDTO);
//        }
//        dto.setProduto(produto);

        return dto;
    }


}
