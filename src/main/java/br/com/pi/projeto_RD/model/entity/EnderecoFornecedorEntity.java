package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ENDERECO_FORNECEDOR")
@Data
public class EnderecoFornecedorEntity implements Serializable {

    @Id
    @Column(name = "ID_ENDERECO")
    private Integer id_endereco;

    @Id
    @Column(name = "ID_FORNECEDOR")
    private Integer id_fornecedor;
}
