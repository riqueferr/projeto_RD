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

        for (ProdutoEntity item : f.getProdutos()) {
            ProdutoFilialDTO eDTO = new ProdutoFilialDTO();

            eDTO.setCodigo(item.getCodigo());
            eDTO.setNm_fantasia(item.getNm_fantasia());
            eDTO.setStatusProduto(item.getStatus().getDsStatusProduto());
            eDTO.setCategoria(item.getCategoria().getDsCategoria());
            eDTO.setTipoProduto(item.getTipo_produto().getDsTipoProduto());
            eDTO.setVl_unidade(item.getVl_unidade());

            produto.add(eDTO);
        }
        dto.setProdutos(produto);
        return dto;
    }
}
