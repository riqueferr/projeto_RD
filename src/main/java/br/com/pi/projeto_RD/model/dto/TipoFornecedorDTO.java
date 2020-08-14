package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoFornecedorDTO implements Serializable {

    private Long id_tipo_fornecedor;
    private String ds_tipo_fornecedor;

}
