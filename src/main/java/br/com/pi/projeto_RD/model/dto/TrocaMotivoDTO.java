package br.com.pi.projeto_RD.model.dto;


import lombok.Data;

@Data
public class TrocaMotivoDTO {

    private Long idFilial;
    private String nmFilial;
    private double totalTroca;
    private double totalDesistencia;

}
