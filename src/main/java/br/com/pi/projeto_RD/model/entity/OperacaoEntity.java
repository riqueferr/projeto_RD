package br.com.pi.projeto_RD.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "TB_OPERACAO")
@Entity
public class OperacaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_OPERACAO")
    private Long cdOperacao;

    @Column(name = "ID_TIPO_OPERACAO")
    @JsonIgnore
    private Long idTipoOperacao;

    @Column(name = "DS_OPERACAO")
    private String dsOperacao;

}
