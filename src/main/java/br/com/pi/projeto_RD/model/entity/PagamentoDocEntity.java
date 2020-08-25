package br.com.pi.projeto_RD.model.entity;

import lombok.Data;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TB_PAGAMENTO_DOC")
public class PagamentoDocEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    private TipoPagamentoEntity tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private DocumentoFiscalEntity documentoFiscal;

    @Column(name = "VL_PAGAMENTO")
    private Double vlPagamento;

}