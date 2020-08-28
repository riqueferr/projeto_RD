package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoFilialDTO {

    private Integer cdEstoque;
//    private FilialEntity filial;
//    private Long cdFilial;
    private Integer cdProduto;
    private String nm_fantasia;
    private String statusProduto;
    private double vl_unidade;
    private String subCategoria;
    private String tipoProduto;
    private int quantidade;
    private int qt_empenho;
    private Integer qt_base;

    private List<ProdutoFilialEstoqueEntity> produtoEstoque;

}
