package br.com.pi.projeto_RD.model.entity;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TB_FILIAL")
@Data
public class FilialEntity {

    @Id
    @Column(name = "CD_FILIAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cd_filial;

    @Column(name = "NM_FILIAL")
    private String nm_filial;

    @Column(name = "NR_CNPJ")
    private String nr_cnpj;

    @Column(name = "NR_TELEFONE")
    private String nr_telefone;

    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_FILIAL_ESTOQUE",
            joinColumns = @JoinColumn(name = "ID_FILIAL"),
            inverseJoinColumns = @JoinColumn(name = "CD_PRODUTO")
    )
    private List<ProdutoEntity> produtos;

}