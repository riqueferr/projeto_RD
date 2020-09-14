package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class DFTransferenciaDTO {

    private BigInteger idDocumento;
    private OperacaoEntity operacao;

    private BigInteger idFilial;
    private String nmFilial;

    private BigInteger idFilialDestino;
    private String nmFilialDestino;

    private BigInteger chaveAcesso;
    private BigInteger nrNF;
    private BigInteger nrSerie;

    private Date dtEmissao;
    private Date dtEntrada;

    private String emissao;
    private String entrada;

    private BigDecimal vlDocumentoFiscal;

    private List<ItensDfDTO> itens;
}
