package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.Date;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DFEntradaDTO {

    private Long idDocumento;
    private OperacaoEntity operacao;

    private Long idFilial;
    private String nmFilial;

    private Long idFilialDestino;

//    private List<FornecedorComprimidoDTO> itens;
    private Long idFornecedor;
    private String nmFornecedor;

    private Long chaveAcesso;
    private Long nrNF;
    private Long nrSerie;

//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dtEmissao;

//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dtEntrada;

    private Date dtAbertura;
    private Date dtFechamento;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal vlDocumentoFiscal;

    private List<ItensDfDTO> itens;


}
