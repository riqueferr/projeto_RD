package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_PERFIL")
@Data
public class PerfilEntity {

    @Id
    @Column(name = "ID_PERFIL")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DS_PERFIL")
    private String dsPerfil;

}
