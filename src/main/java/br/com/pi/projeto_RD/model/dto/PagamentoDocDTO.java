package br.com.pi.projeto_RD.model.dto;


import lombok.Data;

@Data
public class PagamentoDocDTO {

    private Long idTipoPagamento;
    private String dsTipoPagamento;
    private double vlPagamento;


}
