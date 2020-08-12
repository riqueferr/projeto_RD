package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO {

    public ProdutoDto parseToDTO(ProdutoEntity p) {
        ProdutoDto dto = new ProdutoDto();

        if (p == null)
            return dto;

        dto.setCodigo(p.getCodigo());
        dto.setNm_fantasia(p.getNm_fantasia());
        dto.setStatusProduto(p.getStatus().getDsStatusProduto());
        dto.setCategoria(p.getCategoria().getDsCategoria());
        dto.setSub_categoria(p.getCategoria().getSubCategoria().getDsSubCategoria());
        dto.setTipo_produto(p.getTipo_produto().getDsTipoProduto());
        dto.setNm_fabricante(p.getNm_fabricante());
        dto.setVl_unidade(p.getVl_unidade());
        dto.setDs_altura(p.getDs_altura());
        dto.setDs_peso(p.getDs_peso());
        dto.setDs_largura(p.getDs_largura());
        dto.setId_imagem(p.getId_imagem());

        return dto;
    }

    public ProdutoEntity parseToEntity(ProdutoDto dto, ProdutoEntity p) {
        if (p == null)
            p = new ProdutoEntity();

        if (dto == null)
            return p;

        dto.setCodigo(p.getCodigo());
        dto.setNm_fantasia(p.getNm_fantasia());
        dto.setStatusProduto(p.getStatus().getDsStatusProduto());
        dto.setCategoria(p.getCategoria().getDsCategoria());
        dto.setSub_categoria(p.getCategoria().getSubCategoria().getDsSubCategoria());
        dto.setTipo_produto(p.getTipo_produto().getDsTipoProduto());
        dto.setNm_fabricante(p.getNm_fabricante());
        dto.setVl_unidade(p.getVl_unidade());
        dto.setDs_altura(p.getDs_altura());
        dto.setDs_peso(p.getDs_peso());
        dto.setDs_largura(p.getDs_largura());
        dto.setId_imagem(p.getId_imagem());

        return p;
    }

}
