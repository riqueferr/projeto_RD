package br.com.pi.projeto_RD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO implements Serializable {

    private Long id_documento;
    private Integer cd_operacap;
    private Integer cd_filial;
    private Integer id_cliente;
    private Integer id_forncedor;
    private Integer id_recarga;
    private Integer id_motivo;
    private Integer nr_chave_acesso;
    private Integer nr_nf;
    private Integer nr_serie;
    private Date dt_emissao;
    private Date dt_entrada;
    private Date dt_abertura;
    private Date dt_fechamento;
    private Integer fl_nf;
    private Double vl_documento_fiscal;
    private Long nr_caixa;


}

