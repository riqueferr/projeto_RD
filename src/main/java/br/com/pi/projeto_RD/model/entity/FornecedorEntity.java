package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_FORNECEDOR")
@Data
public class FornecedorEntity implements Serializable {

    @Id
    @Column(name = "CD_FORNECEDOR")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cd_fornecedor;

    @Column(name = "NR_CNPJ")
    private String nr_cnpj;

    @Column(name = "NM_FANTASIA")
    private String nm_fantasia;

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
  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_FORNECEDOR")
    @JsonIgnore
    @Id
    //private Integer fk_tipo_fornecedor;
    private TipoFornecedorEntity fk_tipo_fornecedor;



}
