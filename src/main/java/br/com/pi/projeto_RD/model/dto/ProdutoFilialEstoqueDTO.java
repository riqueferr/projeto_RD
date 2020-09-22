package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoFilialEstoqueDTO {

    private BigInteger cdEstoque;

    //INFO FILIAL
    private BigInteger cdFilial;
    private String nmFilial;

    //INFO PRODUTOS
    private BigInteger cdProduto;
    private String nmProduto;

    private String subCategoria;

    //INFO PRODUTO FILIAL ESTOQUE
    private Integer qt_estoque;
    private Integer qt_empenho;
    private Integer qt_base;

}
