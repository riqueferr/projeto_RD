package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoFilialEstoqueDTO {

    private Integer cdEstoque;

    //INFO FILIAL
    private Integer cd_filial;

    //INFO PRODUTOS
    private Integer codProduto;

    //INFO PRODUTO FILIAL ESTOQUE
    private Integer qt_estoque;
    private Integer qt_empenho;
    private Integer qt_base;

}
