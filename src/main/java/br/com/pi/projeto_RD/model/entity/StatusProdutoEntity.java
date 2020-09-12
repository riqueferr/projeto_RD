package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_STATUS_PRODUTO")
@Data
public class StatusProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS_PRODUTO")
//    @JsonIgnore
    private BigInteger idStatusProduto;

    @Column(name = "DS_STATUS_PRODUTO")
    private String dsStatusProduto;

}
