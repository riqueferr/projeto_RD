package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
@NamedEntityGraph(name = "ProdutoFilialEstoqueEntity.filial.produto",
        attributeNodes = {
                @NamedAttributeNode("cdEstoque"),
                @NamedAttributeNode("filial"),
                @NamedAttributeNode("produto"),
        }
)
public class ProdutoFilialEstoqueEntity implements Serializable {

    // MUDAR AQUI
    @Id
    @Column(name = "CD_ESTOQUE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger cdEstoque;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    @JsonIgnore
    private FilialEntity filial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_PRODUTO")
    @JsonIgnore
    private ProdutoEntity produto;

    @Column(name = "QT_ESTOQUE")
    private Integer qt_estoque;

    @Column(name = "QT_EMPENHO")
    private Integer qt_empenho;

    @Column(name = "QT_BASE")
    private Integer qt_base;

}
