package br;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovimentoLojaDTO {
    private Long idDocumento;
//    private Long Filial;
//    private Date dtEntrada;
//    private List<PagamentoDocDTO> pagamento;
//    private BigDecimal vlDocumento;
//    private OperacaoEntity operacao;


    public MovimentoLojaDTO(Long idDocumento) {
    }

    public MovimentoLojaDTO(Long idDocumento, FilialEntity filial) {
    }


    public MovimentoLojaDTO(Long idDocumento, FilialEntity filial, Date dtEntrada, List<PagamentoDocEntity> pagamento, BigDecimal vlDocumentoFiscal, OperacaoEntity operacao) {
    }
//    private double total;

}
