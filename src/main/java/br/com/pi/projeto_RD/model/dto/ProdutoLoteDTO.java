package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
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

    private String nm_fantasia;

    private Long id_status_produto;
    private String statusProduto;

    private double vl_unidade;

    private CategoriaEntity categoria;

    private TipoProdutoEntity tipoProduto;

    private Date dt_entrada;

    private Integer id_fornecedor;

    private String nm_fornecedor;

    private Integer id_filial;

    private String nm_filial;

    private Integer id_nf;
}
