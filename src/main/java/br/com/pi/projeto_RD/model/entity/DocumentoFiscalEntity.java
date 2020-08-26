package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
@NamedQuery(name = "buscarNfPorFilial", query = "select n from DocumentoFiscalEntity n where n.filial.nm_filial  =:NM_FILIAL")
@NamedQuery(name = "buscarNfPorDataEntrada", query = "select n from DocumentoFiscalEntity n where n.dtEntrada  =:DT_ENTRADA")
public class DocumentoFiscalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long idDocumento;

    @ManyToOne
    @JoinColumn(name = "CD_OPERACAO")//fk
    private OperacaoEntity operacao;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")//fk
    private FilialEntity filial;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL_DESTINO")
    private FilialEntity destino;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")//fk
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR")//fk
    private FornecedorEntity fornecedor;

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

//    @OneToMany(mappedBy = "nf", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private List<DocumentoItemEntity> itens;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private List<PagamentoDocEntity> pagamento;


}
