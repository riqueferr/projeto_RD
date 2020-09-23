package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DFEntradaDTO implements Serializable {

    private BigInteger idDocumento;
    private OperacaoEntity operacao;

    private BigInteger idFilial;
    private String nmFilial;

    private BigInteger idFornecedor;
    private String nmFornecedor;

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
