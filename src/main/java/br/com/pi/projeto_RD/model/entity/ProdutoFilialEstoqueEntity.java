package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
public class ProdutoFilialEstoqueEntity {

    @Column(name = "ID_FILIAL")
    private Integer id_filial;

    @Column(name = "ID_PRODUTO")
    private Integer id_produto;

    @Column(name = "QT_ESTOQUE")
    private Integer qt_estoque;

    @Column(name = "QT_EMPENHO")
    private Integer qt_empenho;

    @Column(name = "QT_BASE")
    private Integer qt_base;
}
