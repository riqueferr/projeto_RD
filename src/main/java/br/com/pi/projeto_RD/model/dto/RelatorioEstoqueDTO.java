package br.com.pi.projeto_RD.model.dto;


import lombok.Data;

import java.util.List;

@Data
public class RelatorioEstoqueDTO {

    private Long cd_filial;
    private String nm_filial;
    private List<RelatorioEstoqueProdutoDTO> produto;

}
