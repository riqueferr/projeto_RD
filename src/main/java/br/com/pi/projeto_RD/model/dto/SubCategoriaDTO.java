package br.com.pi.projeto_RD.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
public class SubCategoriaDTO {

    private BigInteger idSubCategoria;
    private String dsSubCategoria;

}
