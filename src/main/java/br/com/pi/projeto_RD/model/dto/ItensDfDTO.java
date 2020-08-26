package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import lombok.Data;

import java.util.List;

@Data
public class ItensDfDTO {

    private Long nrItemDocumento;

    private Integer cdProduto;
    private String nmProduto;

//    private int qtEstoque;
    private Integer qtItem;

    private Double vlItem;
    private Double pcIcms;
    private Double vlIcms;

//    private List<ProdutoFilialEstoqueEntity> produtoEstoque;


}
