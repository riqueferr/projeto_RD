package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_TIPO_PRODUTO")
@Data
public class TipoProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_PRODUTO")
//    @JsonIgnore
    private Long idTipoProduto;

    @Column(name = "DS_TIPO_PRODUTO")
    private String dsTipoProduto;


}
