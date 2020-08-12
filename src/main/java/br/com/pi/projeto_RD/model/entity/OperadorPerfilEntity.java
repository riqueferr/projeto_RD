package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_OPERADOR")
@Data
public class OperadorPerfilEntity {

    @Column(name = "ID_OPERADOR")
    private Integer id_operador;

    @Column(name = "ID_PERFIL")
    private Integer id_perfil;
}
