package br.com.pi.projeto_RD.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
public class TipoProdutoDTO {

    private BigInteger idTipoProduto;
    private String dsTipoProduto;

}
