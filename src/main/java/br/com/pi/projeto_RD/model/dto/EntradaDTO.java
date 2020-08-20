package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDTO {

    private Integer id_entrada;

    //private String nm_produto;
    private List<ProdutoLoteDTO> produto;

    private String dt_entrada;

    //private Long id_fornecedor;
    private String nm_fornecedor;

    //private Integer id_filial;
    private String nm_filial;

    private Long id_documento_fiscal;

}
