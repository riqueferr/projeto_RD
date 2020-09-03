package br.com.pi.projeto_RD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PerfilDTO {

    private Integer id;
    private String dsPerfil;

}
