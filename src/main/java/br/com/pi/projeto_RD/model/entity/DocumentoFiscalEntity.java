package br.com.pi.projeto_RD.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
public class DocumentoFiscalEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long idDocumento;

    @ManyToOne
    @JoinColumn(name = "CD_OPERACAO")//fk
    private OperacaoEntity cdOperacao;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")//fk
    private FilialEntity cdFilial;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")//fk
    private ClienteEntity idCliente;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR")//fk
    private FornecedorEntity idFornecedor;

    @Column(name = "ID_RECARGA")//fk
    private Long idRecarga;

    @Column(name = "ID_MOTIVO")//fk
    private Long idMotivo;

    @Column(name = "NR_CHAVE_ACESSO")
    private Long nrChaveAcesso;

    @Column(name = "NR_NF")
    private Long nrNf;

    @Column(name = "NR_SERIE")
    private Long nrSerie;

    @Column(name = "DT_EMISSAO")
    private Date dtEmissao;

    @Column(name = "DT_ENTRADA")
    private Date dtEntrada;

    @Column(name = "DT_ABERTURA")
    private Date dtAbertura;

    @Column(name = "DT_FECHAMENTO")
    private Date dtFechamento;

    @Column(name = "FL_NF")
    private Integer flNf;

    @Column(name = "VL_DOCUMENTO_FISCAL")
    private Double vlDocumentoFiscal;

    @Column(name = "NR_CAIXA")
    private Long nrCaixa;

}
