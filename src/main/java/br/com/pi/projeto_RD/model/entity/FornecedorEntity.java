package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_FORNECEDOR")
@Data
@NamedQuery(name = "buscarNfPornmFornecedor", query = "select n from FornecedorEntity n where n.nm_razao_social LIKE CONCAT ('%',:nm_razao_social,'%')")
@NamedEntityGraph(name = "FornecedorEntity.enderecos",
        attributeNodes = {
                @NamedAttributeNode("endereco"),
                @NamedAttributeNode("fk_tipo_fornecedor"),
        }
)
public class FornecedorEntity implements Serializable {

    @Id
    @Column(name = "CD_FORNECEDOR")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private BigInteger cd_fornecedor;

    @Column(name = "NR_CNPJ")
    private String nr_cnpj;

    @Column(name = "NM_RAZAO_SOCIAL")
    private String nm_razao_social;

    @Column(name = "DS_DENOMINACAO")
    private String ds_denominacao;

    @Column(name = "NR_INSCRICAO")
    private String nr_inscricao;

    @Column(name = "DS_EMAIL")
    private String ds_email;

    @Column(name = "NR_TELEFONE")
    private String nr_telefone;

    @Column(name = "NR_CELULAR")
    private String nr_celular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPO_FORNECEDOR")
    private TipoFornecedorEntity fk_tipo_fornecedor;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @ManyToMany
//    @JoinTable(name = "TB_ENDERECO_FORNECEDOR",
//            joinColumns = @JoinColumn(name = "CD_FORNECEDOR"),
//            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
//    )
//    private List<EnderecoEntity> endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_FORNECEDOR")
    private List<EnderecoEntity> endereco;


}
