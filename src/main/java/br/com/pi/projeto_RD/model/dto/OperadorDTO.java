package br.com.pi.projeto_RD.model.dto;


import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperadorDTO {


    private Long idOperador;
    private String nmOperador;
    private String nrCpf;
    private Long nrMatricula;
    private String dsCargo;
    private Long cdFilial;
    private String pwOperador;

    private List<PerfilDTO> perfil;

}