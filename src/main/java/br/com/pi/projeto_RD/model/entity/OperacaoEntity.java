package br.com.pi.projeto_RD.model.entity;


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
    private Long idTipoOperacao;

    @Column(name = "DS_OPERACAO")
    private String dsOperacao;

}
