package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovimentoLojaDTO {

    private Long idFilial;
    private String nmFilial;
    private Date dtEntrada;
    private List<PagamentoDocDTO> pagamento;
//    private double total;

}
