package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class FornecedorProdutoDTO {

//    private FornecedorEntity fornecedor;
    private BigInteger cd_fornecedor;
    private String nm_razao_social;
    private String nr_cnpj;
    private String ds_denominacao;

//    private List<FornecedorEntity> fornecedor;


}
