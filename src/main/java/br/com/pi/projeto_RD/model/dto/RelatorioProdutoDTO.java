package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class RelatorioProdutoDTO {

    private BigInteger cdProduto;
    private String nmProduto;
    private String tipoProduto;

    private String statusProduto;

    private List<RelatorioProdutoFornecedorDTO> fornecedor;

}
