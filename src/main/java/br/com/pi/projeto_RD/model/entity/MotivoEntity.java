package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "TB_MOTIVO")
@Entity
public class MotivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "ID_MOTIVO")
    private Long idMotivo;

    @Column(name = "DS_MOTIVO")
    private String dsMotivo;

}
