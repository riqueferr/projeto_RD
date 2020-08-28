package br.com.pi.projeto_RD.model.dto;

import lombok.Data;

@Data
public class RelatorioEstoqueProdutoDTO {

    private Integer cdProduto;
    private String nmProduto;
    private String subCategoria;
    private String tipoProduto;
    private int quantidade;

}
