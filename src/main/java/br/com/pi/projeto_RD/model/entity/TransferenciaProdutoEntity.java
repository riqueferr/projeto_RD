package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_TRANSFERENCIA_PRODUTO")
@Data
public class TransferenciaProdutoEntity {

    @Id
    @Column(name = "ID_TRANSFERENCIA_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transferencia_produto;

    @Column(name = "ID_NF")
    private Integer id_nf;

    @Column(name = "ID_FILIAL")
    private Integer id_filial;

}
