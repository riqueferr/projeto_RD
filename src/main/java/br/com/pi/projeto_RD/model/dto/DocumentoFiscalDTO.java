package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO implements Serializable {

    private Long idDF;
    private OperacaoEntity operacao;
//    private FilialEntity cd_filial;
    private Long idFilial;
    private String nmFilial;
    private ClienteEntity cliente;
    private FornecedorEntity fornecedor;
    private Long id_recarga;
    private MotivoEntity motivo;
    private Long nr_chave_acesso;
    private Long nr_nf;
    private Long nr_serie;


    private Date dt_emissao;

//    private String dt_emissao;
    private Date dt_entrada;
    private Date dt_abertura;
    private Date dt_fechamento;

    private Integer fl_nf;
    private Double vl_documento_fiscal;
    private Long nr_caixa;
    private List<ItensDfDTO> itens;
    private List<PagamentoDocDTO> pagamento;

}

