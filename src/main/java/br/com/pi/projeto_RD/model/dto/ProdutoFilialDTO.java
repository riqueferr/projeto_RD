package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoFilialDTO {

    private Integer codigo;
    private String nm_fantasia;
    private String statusProduto;
    private double vl_unidade;
    private String categoria;
    private String tipoProduto;
    private int qt_produto;

}
