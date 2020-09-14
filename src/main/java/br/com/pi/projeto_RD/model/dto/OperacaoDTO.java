package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import lombok.Data;

import java.math.BigInteger;

@Data
public class OperacaoDTO {

    private BigInteger cdOperacao;
    private String dsOperacao;

}
