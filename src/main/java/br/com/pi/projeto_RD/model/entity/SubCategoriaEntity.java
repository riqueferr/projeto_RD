package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_SUB_CATEGORIA_PRODUTO")
@Data
public class SubCategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUB_CATEGORIA")
//    @JsonIgnore
    private BigInteger idSubCategoria;

    @Column(name = "DS_SUB_CATEGORIA")
    private String dsSubCategoria;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private CategoriaEntity categoria;

}
