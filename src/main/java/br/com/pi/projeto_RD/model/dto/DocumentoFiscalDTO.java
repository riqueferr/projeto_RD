package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO implements Serializable {

    private BigInteger idDF;
    private String operacao;
//    private FilialEntity cd_filial;
    private BigInteger idFilial;
    private String nmFilial;
    private String cliente;
    private String fornecedor;
    private Long id_recarga;
    private MotivoEntity motivo;
    private BigInteger nr_chave_acesso;
    private BigInteger nr_nf;
    private BigInteger nr_serie;


    private Date dt_emissao;

//    private String dt_emissao;
    private Date dt_entrada;
    private Date dt_abertura;
    private Date dt_fechamento;

    private Integer fl_nf;
    private BigDecimal vl_documento_fiscal;
    private Long nr_caixa;
    private List<ItensDfDTO> itens;
    private List<PagamentoDocDTO> pagamento;

}

