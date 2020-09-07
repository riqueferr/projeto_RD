package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "TB_PRODUTO_LOTE")
//@Data
//public class ProdutoLoteEntity {
//
//    @Id
//    @Column(name = "ID_PRODUTO_LOTE")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_produto_lote;
//
//    @Column(name = "DS_LOTE")
//    private String ds_lote;
//
//    @Column(name = "DT_FABRICACAO")
//    private Date dt_fabricacao;
//
//    @Column(name = "DT_VALIDADE")
//    private Date ds_validade;
//
//    @ManyToOne
//    @JoinColumn(name ="CD_PRODUTO")
//    private ProdutoEntity produto;
//
//    @Column(name = "VL_LOTE")
//    private double vl_lote;
//
//}
