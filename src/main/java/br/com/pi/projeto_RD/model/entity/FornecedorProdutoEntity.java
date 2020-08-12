package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_FORNECEDOR_PRODUTO")
@Data
public class FornecedorProdutoEntity {


    @Id
    @Column(name = "ID_FORNECEDOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_fornecedor;

    @Column(name = "FL_FABRICANTE")
    private String fl_fabricante;

    @Column(name = "CD_PRODUTO")
    private String cd_produto;
}
