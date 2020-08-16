package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoFilialEstoqueDTO {
    private Integer fk_filial; //private Filial filial;
    private ProdutoEntity fk_produto;
    private Integer qt_estoque;
    private Integer qt_empenho;
    private Integer qt_base;

}
