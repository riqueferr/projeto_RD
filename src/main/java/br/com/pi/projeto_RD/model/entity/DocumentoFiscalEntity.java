package br.com.pi.projeto_RD.model.entity;

import lombok.Data;
import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "TB_DOCUMENTO_FISCAL")
@Entity
public class DocumentoFiscalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long id_documento;

    @Column(name = "CD_OPERACAO")//fk
    private Integer cd_operacap;

    @Column(name = "CD_FILIAL")//fk
    private Integer cd_filial;

    @Column(name = "ID_CLIENTE")//fk
    private Integer id_cliente;

    @Column(name = "ID_FORNECEDOR")//fk
    private Integer id_forncedor;

    @Column(name = "ID_RECARGA")//fk
    private Integer id_recarga;

    @Column(name = "ID_MOTIVO")//fk
    private Integer id_motivo;

    @Column(name = "NR_CHAVE_ACESSO")
    private Integer nr_chave_acesso;

    @Column(name = "NR_NF")
    private Integer nr_nf;

    @Column(name = "NR_SERIE")
    private Integer nr_serie;

    @Column(name = "DT_EMISSAO")
    private Date dt_emissao;

    @Column(name = "DT_ENTRADA")
    private Date dt_entrada;

    @Column(name = "DT_ABERTURA")
    private Date dt_abertura;

    @Column(name = "DT_FECHAMENTO")
    private Date dt_fechamento;

    @Column(name = "FL_NF")
    private Integer fl_nf;

    @Column(name = "VL_DOCUMENTO_FISCAL")
    private Double vl_documento_fiscal;

    @Column(name = "NR_CAIXA")
    private Long nr_caixa;






}
