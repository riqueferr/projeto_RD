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
    private String nm_operador;
    private String nr_cpf;
    private Long nr_matricula;
    private String ds_cargo;
    private Long cd_filial;
    private String pw_operador;

    private List<PerfilDTO> perfil;

}
