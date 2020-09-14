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

    @Autowired
            private FilialBO filialBO;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity d) {
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if (d == null)
            return dto;

        dto.setIdDF(d.getIdDocumento());

        if(d.getOperacao() != null) {
            dto.setOperacao(d.getOperacao().getDsOperacao());
        }

        if(d.getFilial() != null) {
            dto.setIdFilial(d.getFilial().getCdFilial());
            dto.setNmFilial(d.getFilial().getNmFilial());
        }

        if(d.getCliente() != null) {
            dto.setCliente(d.getCliente().getNmCliente());
        }

        if(d.getFornecedor() != null){
            dto.setFornecedor(d.getFornecedor().getNm_razao_social());
        }

        if(d.getIdRecarga() != null) {
            dto.setId_recarga(d.getIdRecarga());
        }

        if(d.getMotivo() != null) {
            dto.setMotivo(d.getMotivo());
        }

        dto.setNr_chave_acesso(d.getNrChaveAcesso());
        dto.setNr_nf(d.getNrNf());
        dto.setNr_serie(d.getNrSerie());

        if(d.getDtEmissao() != null) {
            dto.setDt_emissao(d.getDtEmissao());
        }

        if(d.getDtEntrada() != null) {
            dto.setDt_entrada(d.getDtEntrada());
        }

        if(d.getDtAbertura() != null) {
            dto.setDt_abertura(d.getDtAbertura());
        }

        if(d.getDtFechamento() != null) {
            dto.setDt_fechamento(d.getDtFechamento());
        }

        dto.setFl_nf(d.getFlNf());
        dto.setVl_documento_fiscal(d.getVlDocumentoFiscal());
        dto.setNr_caixa(d.getNrCaixa());

        List<ItensDfDTO> itens = new ArrayList<>();

        for (DocumentoItemEntity item : d.getItens()) {
            ItensDfDTO eDTO = new ItensDfDTO();

            eDTO.setNrItemDocumento(item.getNrItemDocumento());
            eDTO.setCdProduto(item.getProduto().getCodigo());
            eDTO.setNmProduto(item.getProduto().getNm_fantasia());
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
