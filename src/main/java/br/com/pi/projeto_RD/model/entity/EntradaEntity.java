package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_ENTRADA")
@Data
public class EntradaEntity {

    @Id
    @Column(name = "ID_ENTRADA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrada;

    @Column(name = "NM_PRODUTO")
    private String nm_produto;

    @Column(name = "DT_ENTRADA")
    private Date dt_entrada;

    @Column(name = "ID_FORNECEDOR")
    private Integer id_fornecedor;

    @Column(name = "ID_FILIAL")
    private Integer id_filial;

    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Integer id_documento_fiscal;

    @Column(name = "ID_ENTRADA_LOTE")
    private Integer id_entrada_lote;
}
