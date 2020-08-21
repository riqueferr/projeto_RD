package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoLoteDTO {

    private Integer cd_lote;
    private String dsLote;
    private String dtFabricacao;
    private String dtValidade;

    private Integer idProduto;
    private String nm_fantasia;

    private Long id_status_produto;
    private String statusProduto;

    private double vl_unidade;

    private CategoriaEntity categoria;

    private TipoProdutoEntity tipoProduto;

//    private FornecedorEntity fornecedor;

}
