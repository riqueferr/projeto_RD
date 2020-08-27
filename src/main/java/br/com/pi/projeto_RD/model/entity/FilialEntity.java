package br.com.pi.projeto_RD.model.entity;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_FILIAL")
@Data
@NamedQuery(name = "buscarNfPornmFilial", query = "select n from FilialEntity n where n.nmFilial  =:NM_FILIAL")
public class FilialEntity {

    @Id
    @Column(name = "CD_FILIAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdFilial;

    @Column(name = "NM_FILIAL")
    private String nmFilial;

    @Column(name = "NR_CNPJ")
    private String nr_cnpj;

    @Column(name = "NR_TELEFONE")
    private String nr_telefone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_FILIAL")
    private List<ProdutoFilialEstoqueEntity> produtos;


}
