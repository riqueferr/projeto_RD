package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Data
//@Table(name = "TB_ENDERECO_FORNECEDOR")
//@Entity
//public class EnderecoFornecedorEntity implements Serializable {
//
//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ID_ENDERECO")
//    private EnderecoEntity endereco;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CD_FORNECEDOR")
//    @JsonIgnore
//    @Id
//    private FornecedorEntity fornecedor;
//
//}
