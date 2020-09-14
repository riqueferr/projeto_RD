package br.com.pi.projeto_RD.model.dto;


import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class RelatorioEstoqueDTO {

    private BigInteger cd_filial;
    private String nm_filial;
    private List<RelatorioEstoqueProdutoDTO> produto;

}
