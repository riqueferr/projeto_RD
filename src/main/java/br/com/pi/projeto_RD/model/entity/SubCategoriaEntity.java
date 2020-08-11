package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_SUB_CATEGORIA_PRODUTO")
@Data
public class SubCategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUB_CATEGORIA")
    private Long idSubCategoria;

    @Column(name = "DS_SUB_CATEGORIA")
    private String dsSubCategoria;

}
