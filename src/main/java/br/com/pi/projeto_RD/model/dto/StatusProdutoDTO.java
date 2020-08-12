package br.com.pi.projeto_RD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
public class StatusProdutoDTO {

    private Long idStatusProduto;
    private String dsStatusProduto;

}
