package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.SubCategoriaEntity;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CategoriaDTO {

    private Long idCategoria;
    private String dsCategoria;
    private SubCategoriaDTO subCategoria;

}
