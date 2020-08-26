package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.EnderecoEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelatorioProdutoBO {

    @Autowired
    ProdutoRepository repository;

    public RelatorioProdutoDTO parseToDTO(ProdutoEntity p) {
        RelatorioProdutoDTO dto = new RelatorioProdutoDTO();

        dto.setCdProduto(p.getCodigo());
        dto.setNmProduto(p.getNm_fantasia());
        dto.setTipoProduto(p.getTipo_produto().getDsTipoProduto());
        dto.setStatusProduto(p.getStatus().getDsStatusProduto());

        if (p == null)
            return dto;

        List<RelatorioProdutoFornecedorDTO> fornecedor = new ArrayList<>();

        for (FornecedorEntity item : p.getFornecedor()) {
            RelatorioProdutoFornecedorDTO fDTO = new RelatorioProdutoFornecedorDTO();
//            fDTO.setCd_fornecedor(item.getCd_fornecedor());
            fDTO.setNm_razao_social(item.getNm_razao_social());

            fornecedor.add(fDTO);
        }

        dto.setFornecedor(fornecedor);

        return dto;
    }

}
