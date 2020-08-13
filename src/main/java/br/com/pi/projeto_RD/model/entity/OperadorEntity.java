package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_OPERADOR")
@Data
public class OperadorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERADOR")
    private Long idOperador;

    @Column(name = "NM_NOME")
    private String nm_operador;

    @Column(name = "NR_CPF")
    private String nr_cpf;

    @Column(name = "NR_MATRICULA")
    private Long nr_matricula;

    @Column(name = "DS_CARGO")
    private String ds_cargo;

    @Column(name = "CD_FILIAL")
    private Long cd_filial;

    @Column(name = "PW_OPERADOR")
    private String pw_operador;


}
