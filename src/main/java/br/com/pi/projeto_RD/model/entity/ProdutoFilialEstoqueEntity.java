package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
public class ProdutoFilialEstoqueEntity implements Serializable {

    // MUDAR AQUI
    @Id
    @Column(name = "CD_ESTOQUE")
    private Integer cdEstoque;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    private  FilialEntity filial;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private  ProdutoEntity produto;

    @Column(name = "QT_ESTOQUE")
    private Integer qt_estoque;

    @Column(name = "QT_EMPENHO")
    private Integer qt_empenho;

    @Column(name = "QT_BASE")
    private Integer qt_base;
}
