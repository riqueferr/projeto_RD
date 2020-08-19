package br.com.pi.projeto_RD.model.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoLoteDTO implements Serializable {

    private Integer idProdutoLote;
    private String dsLote;
    private Date dtFabricacao;
    private Date dtValidade;
    private Integer fkProduto;
    private Double vlLote;


}
