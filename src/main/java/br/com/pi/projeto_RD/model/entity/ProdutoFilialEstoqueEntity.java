package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
public class ProdutoFilialEstoqueEntity implements Serializable {

    @Id
    @Column(name = "ID_FILIAL")
    private Integer id_filial;

    @Id
    @Column(name = "ID_PRODUTO")
    private Integer id_produto;

    @Id
    @Column(name = "QT_ESTOQUE")
    private Integer qt_estoque;

    @Id
    @Column(name = "QT_EMPENHO")
    private Integer qt_empenho;

    @Id
    @Column(name = "QT_BASE")
    private Integer qt_base;
}
