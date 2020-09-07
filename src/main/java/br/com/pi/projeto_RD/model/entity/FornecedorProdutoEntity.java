package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_FORNECEDOR_PRODUTO")
@Data
public class FornecedorProdutoEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "CD_FORNECEDOR")
    private FornecedorEntity fornecedor;

    @Column(name = "FL_FABRICANTE")
    private String flFabricante;

    @Id
    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;
}
