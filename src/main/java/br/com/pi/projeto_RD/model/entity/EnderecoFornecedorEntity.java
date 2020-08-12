package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO_FORNECEDOR")
@Data
public class EnderecoFornecedorEntity {

    @Column(name = "ID_ENDERECO")
    private Integer id_endereco;

    @Column(name = "ID_FORNECEDOR")
    private Integer id_fornecedor;
}
