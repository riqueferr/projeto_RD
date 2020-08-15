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
    @Column(name = "ID_FILIAL")
    private Integer fk_id_filial;
    // MUDAR AQUI


    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private  ProdutoEntity produto;

    @Column(name = "QT_ESTOQUE")
    private Integer qt_estoque;

    @Column(name = "QT_EMPENHO")
    private Integer qt_empenho;

    @Column(name = "QT_BASE")
    private Integer qt_base;
}
