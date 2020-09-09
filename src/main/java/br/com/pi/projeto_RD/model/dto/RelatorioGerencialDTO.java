package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatorioGerencialDTO {

    private Long idDocumento;
    private Date dtEntrada;
    private BigDecimal vlDocumento;
    private PagamentoDocEntity pagamento;
    private OperacaoEntity operacao;
    private ProdutoEntity produto;
    private FilialEntity filial;
}
