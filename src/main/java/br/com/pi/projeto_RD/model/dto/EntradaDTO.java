package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDTO {

    private Integer id_entrada;

    private String nm_produto;

    private Date dt_entrada;

    private Integer id_fornecedor;
    private FornecedorEntity fornecedor;

    private Integer id_filial;
    private FilialEntity Filial;

    private Integer id_documento_fiscal;
    private DocumentoFiscalEntity documento;

}
