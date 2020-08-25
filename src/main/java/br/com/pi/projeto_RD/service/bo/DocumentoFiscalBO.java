package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentoFiscalBO {

    @Autowired
    private DocumentoFiscalRepository repository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity d) {
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if (d == null)
            return dto;

        dto.setId_documento(d.getIdDocumento());
        dto.setCd_operacao(d.getOperacao());
        dto.setIdFilial(d.getFilial().getCd_filial());
        dto.setNmFilial(d.getFilial().getNm_filial());
        dto.setId_cliente(d.getCliente());
        dto.setId_fornecedor(d.getFornecedor());
        dto.setId_recarga(d.getIdRecarga());
        dto.setId_motivo(d.getIdMotivo());
        dto.setNr_chave_acesso(d.getNrChaveAcesso());
        dto.setNr_nf(d.getNrNf());
        dto.setNr_serie(d.getNrSerie());

        dto.setDt_emissao(SDF.format(d.getDtEmissao()));
//        dto.setDt_entrada(SDF.format(d.getDtEntrada()));
        dto.setDt_entrada(d.getDtEntrada());
        dto.setDt_abertura(SDF.format(d.getDtAbertura()));
        dto.setDt_fechamento(SDF.format(d.getDtFechamento()));

        dto.setFl_nf(d.getFlNf());
        dto.setVl_documento_fiscal(d.getVlDocumentoFiscal());
        dto.setNr_caixa(d.getNrCaixa());

        List<ItensDfDTO> itens = new ArrayList<>();

        for (DocumentoItemEntity item : d.getItens()) {
            ItensDfDTO eDTO = new ItensDfDTO();

            eDTO.setNrItemDocumento(item.getNrItemDocumento());
//            eDTO.setIdDocumentoFiscal(item.getDf().getIdDocumento());
            eDTO.setCdProduto(item.getProduto().getCodigo());
//            eDTO.setNmProduto(item.getProduto().getNm_fantasia());
            eDTO.setQtItem(item.getQtItem());
            eDTO.setVlItem(item.getVlItem());
            eDTO.setPcIcms(item.getPcIcms());
            eDTO.setVlIcms(item.getVlIcms());

            itens.add(eDTO);
        }
        dto.setItens(itens);

        List<PagamentoDocDTO> pg = new ArrayList<>();

        for (PagamentoDocEntity item : d.getPagamento()) {
            PagamentoDocDTO eDTO = new PagamentoDocDTO();

            eDTO.setIdTipoPagamento(item.getTipoPagamento().getIdTipoPagamento());
            eDTO.setDsTipoPagamento(item.getTipoPagamento().getDsTipoPagamento());
            eDTO.setVlPagamento(item.getVlPagamento());

            pg.add(eDTO);
        }
        dto.setPagamento(pg);

        return dto;

    }


}
