package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Integer codigo;
    private StatusProdutoEntity status;
    private Integer categoria;
    private Integer tipo_produto;
    private String nm_fantasia;
    private String nm_fabricante;

}
