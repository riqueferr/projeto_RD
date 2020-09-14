package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ItensDfDTO {

    private BigInteger nrItemDocumento;
    private BigInteger cdProduto;
    private String nmProduto;
    private Integer qtItem;
    private Double vlItem;
    private Double pcIcms;
    private Double vlIcms;

}
