package br.com.pi.projeto_RD.model.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StatusProdutoDTO {

    @Column(name = "DS_STATUS_PRODUTO")
    private String dsStatusProduto;

}
