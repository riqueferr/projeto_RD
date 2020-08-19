package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_ENTRADA")
@Data
public class EntradaEntity {

    @Id
    @Column(name = "ID_ENTRADA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrada;

    @Column(name = "NM_PRODUTO")
    private String nm_produto;

    @Column(name = "DT_ENTRADA")
    private Date dt_entrada;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR")
    private FornecedorEntity fornecedor;

    @ManyToOne
    @JoinColumn(name = "ID_FILIAL")
    private FilialEntity filial;

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private DocumentoFiscalEntity documento_fiscal;

}
