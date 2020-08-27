package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class EnderecoDTO {

    private Long idEndereco;

    private String dsEndereco;

    private String nrEndereco;

    private String nrCep;

    private String dsBairro;

    private String dsCidade;

    private String sgEstado;

    private String nmComplemento;



}
