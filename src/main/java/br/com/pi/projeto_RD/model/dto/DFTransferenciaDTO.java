package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class DFTransferenciaDTO {

    private Long idDocumento;
    private OperacaoEntity operacao;

    private Long idFilial;
    private String nmFilial;

    private Long idFilialDestino;
    private String nmFilialDestino;

//    private Long idFornecedor;
//    private String nmFornecedor;

    private Long chaveAcesso;
    private Long nrNF;
    private Long nrSerie;
    private Date dtEmissao;
    private Date dtEntrada;
    private Double vlDocumentoFiscal;

    private List<ItensDfDTO> itens;
}
