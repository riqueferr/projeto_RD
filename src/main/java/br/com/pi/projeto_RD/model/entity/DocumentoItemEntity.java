package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_DOCUMENTO_ITEM")
@Data
public class DocumentoItemEntity implements Serializable {

    @Id
    @Column(name = "NR_ITEM_DOCUMENTO")
    private Long nrItemDocumento;

    @Column(name = "QT_ITEM")
    private Integer qtItem;

    @Column(name = "PC_ICMS")
    private Double pcIcms;

    @Column(name = "VL_ICMS")
    private Double vlIcms;

    @Column(name = "VL_ITEM")
    private Double vlItem;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    @JsonIgnore
    @Id
    private DocumentoFiscalEntity nf;

}
