package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_FORNECEDOR")
@Data
public class TipoFornecedorEntity {

    @Id
    @Column(name = "TB_TIPO_FORNECEDOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_fornecedor;

    @Column(name = "DS_TIPO_FORNECEDOR")
    private String ds_tipo_fornecedor;
}