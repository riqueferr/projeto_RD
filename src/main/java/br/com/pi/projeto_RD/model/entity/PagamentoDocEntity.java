package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "TB_PAGAMENTO_DOC")
@NamedQuery(name = "buscarTiposPagamento", query = "select p FROM PagamentoDocEntity AS p WHERE p.documentoFiscal.dtEntrada =: DT_ENTRADA AND p.tipoPagamento.idTipoPagamento = 1 OR p.tipoPagamento.idTipoPagamento = 4")
@NamedQuery(name = "buscarTipoDinheiro", query = "select p FROM PagamentoDocEntity AS p WHERE p.tipoPagamento.idTipoPagamento = 4")
@NamedQuery(name = "buscarTipoCheque", query = "select p FROM PagamentoDocEntity AS p WHERE p.tipoPagamento.idTipoPagamento = 5")
public class PagamentoDocEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    private TipoPagamentoEntity tipoPagamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private DocumentoFiscalEntity documentoFiscal;

    @Column(name = "VL_PAGAMENTO")
    private Double vlPagamento;

}