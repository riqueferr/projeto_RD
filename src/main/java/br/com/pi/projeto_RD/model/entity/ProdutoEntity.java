package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@NamedQuery(name = "buscarNfPoridStatusProduto", query = "select n from ProdutoEntity n where n.status.idStatusProduto  =:ID_STATUS_PRODUTO")
@NamedQuery(name = "buscarNfPordsStatusProduto", query = "select n from ProdutoEntity n where n.status.dsStatusProduto  =:DS_STATUS_PRODUTO")
@NamedQuery(name = "buscarNfPornmProduto", query = "select n from ProdutoEntity n where n.nm_fantasia LIKE CONCAT ('%',:NM_FANTASIA,'%')")
@NamedEntityGraph( name = "produtosfindall",
        attributeNodes = {
                @NamedAttributeNode("fornecedor"),
                @NamedAttributeNode("status"),
                @NamedAttributeNode("subCategoria"),
                @NamedAttributeNode("tipo_produto"),
        }
)

public class ProdutoEntity implements Serializable {

    @Id
    @Column(name = "CD_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger codigo;

    @Column(name = "NM_FANTASIA")
    private String nm_fantasia;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_STATUS_PRODUTO")
    private StatusProdutoEntity status;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_SUB_CATEGORIA")
    private SubCategoriaEntity subCategoria;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_TIPO_PRODUTO")
    private TipoProdutoEntity tipo_produto;

    @Column(name = "NM_FABRICANTE")
    private String nm_fabricante;

    @Column(name = "VL_UNIDADE")
    private BigDecimal vl_unidade;

    @Column(name = "DS_ALTURA")
    private String ds_altura;

    @Column(name = "DS_PESO")
    private String ds_peso;

    @Column(name = "DS_LARGURA")
    private String ds_largura;

//    @Column(name = "ID_IMAGEM")
//    private Integer id_imagem;

    @Column(name = "DS_PRODUTO")
    private String dsProduto;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CD_PRODUTO")
//    private List<FornecedorProdutoEntity> fornecedorProduto;

    @ManyToMany(fetch = FetchType.LAZY )
    @JoinTable(
            name = "TB_FORNECEDOR_PRODUTO",
            joinColumns = @JoinColumn(name = "CD_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "CD_FORNECEDOR")
    )
    private List<FornecedorEntity> fornecedor;

}
