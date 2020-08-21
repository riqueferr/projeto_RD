package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilialDTO {

    private Long cd_filial;
    private String nm_filial;
    private String nr_cpnj;
    private String nr_telefone;
    private List<ProdutoFilialDTO> produto;

}
