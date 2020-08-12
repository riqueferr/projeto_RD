package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_OPERADOR")
@Data
public class OperadorPerfilEntity implements Serializable {

    @Id
    @Column(name = "ID_OPERADOR")
    private Integer id_operador;

    @Id
    @Column(name = "ID_PERFIL")
    private Integer id_perfil;
}
