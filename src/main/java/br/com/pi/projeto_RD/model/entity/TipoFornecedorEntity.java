package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_TIPO_FORNECEDOR")
@Data
public class TipoFornecedorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_FORNECEDOR")
    //@JsonIgnore
    private Long id_tipo_fornecedor;

    @Column(name = "DS_TIPO_FORNECEDOR")
    private String ds_tipo_fornecedor;

}
