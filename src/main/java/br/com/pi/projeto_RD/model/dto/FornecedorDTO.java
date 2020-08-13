package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.TipoFornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FornecedorDTO {

    private Long cd_fornecedor;
    private String nr_cnpj;
    private String nm_fantasia;
    private String nm_razao_social;
    private String ds_denominacao;
    private String nr_inscricao;
    private String ds_email;
    private String nr_telefone;
    //private TipoFornecedorEntity fk_tipo_fornecedor;
}
