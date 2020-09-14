package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
@NoArgsConstructor
@NamedQuery(name = "buscarNfPorFilial", query = "select n from DocumentoFiscalEntity n where n.filial.nmFilial  =:NM_FILIAL")
@NamedQuery(name = "filtrarDataeFilial", query = "Select n from DocumentoFiscalEntity n JOIN n.pagamento p WHERE n.operacao.cdOperacao = 1 AND p.tipoPagamento.idTipoPagamento = 4 OR p.tipoPagamento.idTipoPagamento = 5 AND n.dtEntrada = :DT_ENTRADA AND n.filial.cdFilial = :FILIAL")
@NamedQuery(name = "buscarNfPorDataEntrada", query = "select n.dtEntrada from DocumentoFiscalEntity AS n where dtEntrada  = :DT_ENTRADA")
//@NamedQuery(name = "buscarTiposPagamento", query = "select n from DocumentoFiscalEntity n where n.idPagamento =:ID_PAGAMENTO")
//@NamedQuery(name = "testePagamento", query =  "Select n from DocumentoFiscalEntity n WHERE n.operacao.cdOperacao = 4")
//@NamedQuery(name = "seila", query = "Select MovimentoLojaDTO(n.idDocumento)")
//@SqlResultSetMapping(name = "testeBusca", entities = {@EntityResult(entityClass = DocumentoFiscalEntity.class),@EntityResult(entityClass = PagamentoDocEntity.class)})

@NamedEntityGraph( name = "documentosfindall",
        attributeNodes = {
                @NamedAttributeNode("filial"),
                @NamedAttributeNode("destino"),
                @NamedAttributeNode("fornecedor")
        }
)
public class DocumentoFiscalEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private BigInteger idDocumento;

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

    @ManyToOne
    @JoinColumn(name = "ID_MOTIVO")//fk
    private MotivoEntity motivo;

    @Column(name = "ID_RECARGA")//fk
    private Long idRecarga;

    @Column(name = "NR_CHAVE_ACESSO")
    private BigInteger nrChaveAcesso;

    @Column(name = "NR_NF")
    private BigInteger nrNf;

    @Column(name = "NR_SERIE")
    private BigInteger nrSerie;

    @Column(name = "DT_EMISSAO")
    private Date dtEmissao;

    @Column(name = "DT_ENTRADA")
    @Temporal(value = TemporalType.DATE)
    private Date dtEntrada;

    @Column(name = "DT_ABERTURA")
    private Date dtAbertura;

    @Column(name = "DT_FECHAMENTO")
    private Date dtFechamento;

    @Column(name = "FL_NF")
    private Integer flNf;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "VL_DOCUMENTO_FISCAL", columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal vlDocumentoFiscal;

    @Column(name = "NR_CAIXA")
    private Long nrCaixa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private List<DocumentoItemEntity> itens;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private List<PagamentoDocEntity> pagamento;

}
