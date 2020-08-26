package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "TB_CLIENTE")
@Entity
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "NM_CLIENTE")
    private String nmCliente;

    @Column(name = "NR_CPF")
    private String nrCPF;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Column(name = "DT_CADASTRO")
    private Date dtCadastro;

    @Column(name = "NR_RG")
    private String nrRg;

    @Column(name = "DT_NASC")
    private Date dtNasc;

    @Column(name = "DS_GENERO")
    private String dsGenero;

    @Column(name = "NR_TELEFONE1")
    private String nrTelefone1;

    @Column(name = "ID_CATEGORIA_CLIENTE")
    private Integer idCategoriaCliente;

    @Column(name = "PW_CLIENTE")
    private String pwCliente;

    @Column(name = "NR_TELEFONE2")
    private String nrTelefone2;
}
