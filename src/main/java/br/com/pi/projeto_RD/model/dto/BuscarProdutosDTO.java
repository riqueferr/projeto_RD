package br.com.pi.projeto_RD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuscarProdutosDTO {
    private Integer codigo;
    private String nm_fantasia;
    private String dsStatusProduto;
}
