package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "TB_DOCUMENTO_ITEM")
@Data
public class DocumentoItemEntity implements Serializable {

    @Id
    @Column(name = "NR_ITEM_DOCUMENTO")
    private BigInteger nrItemDocumento;

    @Column(name = "QT_ITEM")
    private Integer qtItem;

    @Column(name = "PC_ICMS")
    private BigDecimal pcIcms;

    @Column(name = "VL_ICMS")
    private BigDecimal vlIcms;

    @Column(name = "VL_ITEM")
    private BigDecimal vlItem;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    @JsonIgnore
    @Id
    private DocumentoFiscalEntity nf;

}
