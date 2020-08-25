package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DFEntradaBO {

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PersistenceContext
    private EntityManager em;


    public DFEntradaDTO parseToDTO(DocumentoFiscalEntity d) {
        DFEntradaDTO dto = new DFEntradaDTO();

        if (d == null)
            return dto;

        dto.setIdDocumento(d.getIdDocumento());
        dto.setOperacao(d.getOperacao());

        dto.setIdFilial(d.getFilial().getCd_filial());
        dto.setNmFilial(d.getFilial().getNm_filial());

        dto.setIdFornecedor(d.getFornecedor().getCd_fornecedor());
        dto.setNmFornecedor(d.getFornecedor().getNm_razao_social());

        dto.setChaveAcesso(d.getNrChaveAcesso());
        dto.setNrNF(d.getNrNf());
        dto.setNrSerie(d.getNrSerie());
        dto.setDtEmissao(d.getDtEmissao());
        dto.setDtEntrada(d.getDtEntrada());
        dto.setVlDocumentoFiscal(d.getVlDocumentoFiscal());

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

//            List<ProdutoFilialEstoqueEntity> itemsEntity = new ArrayList<>();
//            for (ProdutoFilialDTO itemDTO : item.getProduto().getEstoqueProdutos()) {
//                ProdutoFilialEstoqueEntity Entity = new ProdutoFilialEstoqueEntity();
//
//                itemsEntity.add(Entity);
//            }
//            eDTO.setProdutoEstoque(itemsEntity);

            itens.add(eDTO);

        }
        dto.setItens(itens);

        return dto;

    }

    public DocumentoFiscalEntity parseToEntity(DFEntradaDTO dto, DocumentoFiscalEntity dfEntity) throws Exception {
        if (dfEntity == null)
            dfEntity = new DocumentoFiscalEntity();

        if (dto == null)
            return dfEntity;

        dfEntity.setIdDocumento(dto.getIdDocumento());
//        dfEntity.setOperacao(dto.getOperacao());

//        dfEntity.setOperacao(operacaoRepository.getOne(dto.getOperacao().getCdOperacao()));
//        dfEntity.setFilial(filialRepository.getOne(dto.getIdFilial()));
//        dfEntity.setFornecedor(fornecedorRepository.getOne(dto.getIdFornecedor()));
        dfEntity.setNrChaveAcesso(dto.getChaveAcesso());
        dfEntity.setNrNf(dto.getNrNF());
        dfEntity.setNrSerie(dto.getNrSerie());
        dfEntity.setDtEmissao(dto.getDtEmissao());
        dfEntity.setDtEntrada(dto.getDtEntrada());
        dfEntity.setVlDocumentoFiscal(dto.getVlDocumentoFiscal());

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();
        for (ItensDfDTO itemDTO : dto.getItens()) {
            DocumentoItemEntity itEntity = new DocumentoItemEntity();

            itEntity.setNrItemDocumento(itemDTO.getNrItemDocumento());

//            itEntity.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
            itEntity.setQtItem(itemDTO.getQtItem());
            itEntity.setVlItem(itemDTO.getVlItem());
            itEntity.setPcIcms(itemDTO.getPcIcms());
            itEntity.setVlIcms(itemDTO.getVlIcms());

            itemsEntity.add(itEntity);
        }

        dfEntity.setItens(itemsEntity);


        return dfEntity;
    }


}
