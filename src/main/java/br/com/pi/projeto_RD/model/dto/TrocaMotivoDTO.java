package br.com.pi.projeto_RD.model.dto;


import lombok.Data;

import java.math.BigInteger;

@Data
public class TrocaMotivoDTO {

    private BigInteger idFilial;
    private String nmFilial;
    private double totalTroca;
    private double totalDesistencia;

}
