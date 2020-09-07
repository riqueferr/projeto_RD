package br.com.pi.projeto_RD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "TB_ENDERECO")
@Entity
public class EnderecoEntity {

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(name = "DS_ENDERECO")
    private String dsEndereco;

    @Column(name = "NR_ENDERECO")
    private String nrEndereco;

    @Column(name = "NR_CEP")
    private String nrCep;

    @Column(name = "DS_BAIRRO")
    private String dsBairro;

    @Column(name = "DS_CIDADE")
    private String dsCidade;

    @Column(name = "SG_ESTADO")
    private String sgEstado;

    @Column(name = "NM_COMPLEMENTO")
    private String nmComplemento;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CD_FORNECEDOR")
//    @JsonIgnore
//    private FornecedorEntity fornecedor;

}
