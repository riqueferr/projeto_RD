package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
public class MovimentoLojaDTO {
    private BigInteger idDocumento;
    private FilialEntity filial;
    private Date dtEntrada;
//    private List<PagamentoDocDTO> pagamento;
    private BigDecimal vlDocumento;
    private OperacaoEntity operacao;


//    public MovimentoLojaDTO(Long idDocumento) {
//    }
//
//    public MovimentoLojaDTO(Long idDocumento, FilialEntity filial) {
//    }


    public MovimentoLojaDTO(BigInteger idDocumento, Date dtEntrada, BigDecimal vlDocumento, OperacaoEntity operacao, FilialEntity filial) {
        this.idDocumento = idDocumento;
        this.dtEntrada = dtEntrada;
        this.vlDocumento = vlDocumento;
        this.operacao = operacao;
        this.filial = filial;
    }
//    private double total;

}
