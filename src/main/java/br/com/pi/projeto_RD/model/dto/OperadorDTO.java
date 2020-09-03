package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorDTO {

    private BigInteger idOperador;
    private String nmOperador;
    private String nrCpf;
    private BigInteger nrMatricula;
    private String dsCargo;
    private BigInteger cdFilial;
    private String pwOperador;

    private List<PerfilDTO> perfil;

}