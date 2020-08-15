package br.com.pi.projeto_RD.model.dto;

import lombok.Data;

@Data
public class FornecedorProdutoDTO {

    private Long cd_fornecedor;
    private String nm_razao_social;
    private String nr_cnpj;
    private String ds_denominacao;


}
