package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_TIPO_PAGAMENTO")
public class TipoPagamentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_PAGAMENTO")
    private Long  idTipoPagamento;

    @Column(name = "DS_TIPO_PAGAMENTO")
    private String dsTipoPagamento;

}