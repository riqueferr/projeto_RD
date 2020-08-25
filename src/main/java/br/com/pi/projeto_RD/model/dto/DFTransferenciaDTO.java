package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DFTransferenciaDTO {

    private Long idDocumentoFiscal;
    private OperacaoEntity operacao;

    private Long idFilial;
    private String nmFilial;

    private Long idFilialDestino;
    private String nmFilialDestino;

    private Long chaveAcesso;
    private Long nrNF;
    private Long nrSerie;
    private Date dtEmissao;
    private Date dtEntrada;

    private List<ItensDfDTO> itens;

}
