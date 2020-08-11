package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
@Data
public class ProdutoEntity {

    @Id
    @Column(name = "CD_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "ID_STATUS_PRODUTO")
    private Integer status_produto;

    @Column(name = "ID_CATEGORIA")
    private Integer categoria;

    @Column(name = "ID_TIPO_PRODUTO")
    private Integer tipo_produto;

    @Column(name = "NM_FANTASIA")
    private String nm_fantasia;

    @Column(name = "NM_FABRICANTE")
    private String nm_fabricante;

    @Column(name = "VL_UNIDADE")
    private double vl_unidade;

    @Column(name = "DS_ALTURA")
    private String ds_altura;

    @Column(name = "DS_PESO")
    private String ds_peso;

    @Column(name = "DS_LARGURA")
    private String ds_largura;

    @Column(name = "ID_IMAGEM")
    private Integer id_imagem;

}