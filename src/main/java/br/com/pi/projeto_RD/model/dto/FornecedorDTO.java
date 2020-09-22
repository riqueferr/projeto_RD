package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.EnderecoEntity;
import br.com.pi.projeto_RD.model.entity.TipoFornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FornecedorDTO {

    private BigInteger cd_fornecedor;
    private String nr_cnpj;
    private String nm_razao_social;
    private String ds_denominacao;
    private String nr_inscricao;
    private String ds_email;
    private String nr_telefone;
    private String nr_celular;

    private TipoFornecedorEntity fk_tipo_fornecedor;
    private List<EnderecoDTO> endereco;

}
