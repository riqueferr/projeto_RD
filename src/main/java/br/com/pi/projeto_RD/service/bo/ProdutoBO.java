package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.CategoriaRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.repository.StatusRepository;
import br.com.pi.projeto_RD.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public ProdutoDto parseToDTO(ProdutoEntity p) {
        ProdutoDto dto = new ProdutoDto();

        if (p == null)
            return dto;

        dto.setCodigo(p.getCodigo());
        dto.setNm_fantasia(p.getNm_fantasia());
        dto.setStatusProduto(p.getStatus());
        dto.setCategoria(p.getCategoria());
        dto.setTipo_produto(p.getTipo_produto());
        dto.setNm_fabricante(p.getNm_fabricante());
        dto.setVl_unidade(p.getVl_unidade());
        dto.setDs_altura(p.getDs_altura());
        dto.setDs_peso(p.getDs_peso());
        dto.setDs_largura(p.getDs_largura());
        dto.setId_imagem(p.getId_imagem());

        return dto;
    }

    public ProdutoEntity parseToEntity(ProdutoDto dto, ProdutoEntity pEntity) throws Exception {
        if (pEntity == null)
            pEntity = new ProdutoEntity();

        if (dto == null)
            return pEntity;

        pEntity.setCodigo(dto.getCodigo());
        pEntity.setNm_fantasia(dto.getNm_fantasia());
        pEntity.setStatus(statusRepository.getOne(dto.getStatusProduto().getIdStatusProduto()));
        pEntity.setCategoria(categoriaRepository.getOne(dto.getCategoria().getIdCategoria()));
        pEntity.setTipo_produto(tipoProdutoRepository.getOne(dto.getTipo_produto().getIdTipoProduto()));
        pEntity.setNm_fabricante(dto.getNm_fabricante());
        pEntity.setVl_unidade(dto.getVl_unidade());
        pEntity.setDs_altura(dto.getDs_altura());
        pEntity.setDs_peso(dto.getDs_peso());
        pEntity.setDs_largura(dto.getDs_largura());
        pEntity.setId_imagem(dto.getId_imagem());

        return pEntity;
    }

}
