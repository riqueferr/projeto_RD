package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DFEntradaDTO {

    private Long idDocumento;
    private OperacaoEntity operacao;

    private Long idFilial;
    private String nmFilial;

    private Long idFilialDestino;

    private Long idFornecedor;
    private String nmFornecedor;

    private Long chaveAcesso;
    private Long nrNF;
    private Long nrSerie;
    private Date dtEmissao;
    private Date dtEntrada;
    private Double vlDocumentoFiscal;

    private List<ItensDfDTO> itens;


}
