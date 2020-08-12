package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORIA_PRODUTO")
@Data
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @Column(name = "DS_CATEGORIA")
    private String dsCategoria;

//    @Column(name = "ID_SUB_CATEGORIA")
//    private Long idSubCategoria;

    @OneToOne
    @JoinColumn(name = "ID_SUB_CATEGORIA")
    private SubCategoriaEntity subCategoria;


}
