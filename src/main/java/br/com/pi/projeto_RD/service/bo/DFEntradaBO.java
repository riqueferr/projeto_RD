package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    public DFEntradaDTO parseToDTO(DocumentoFiscalEntity d) {
        DFEntradaDTO dto = new DFEntradaDTO();

        if (d == null)
            return dto;

        dto.setIdDocumento(d.getIdDocumento());
        dto.setOperacao(d.getOperacao());

        dto.setIdFilial(d.getFilial().getCdFilial());
        dto.setNmFilial(d.getFilial().getNmFilial());

        dto.setIdFornecedor(d.getFornecedor().getCd_fornecedor());
        dto.setNmFornecedor(d.getFornecedor().getNm_razao_social());

        dto.setChaveAcesso(d.getNrChaveAcesso());
        dto.setNrNF(d.getNrNf());
        dto.setNrSerie(d.getNrSerie());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        dto.setEmissao(formato.format(d.getDtEmissao()));
        dto.setEntrada(formato.format(d.getDtEntrada()));
//        dto.setDtAbertura(d.getDtAbertura());
//        dto.setDtFechamento(d.getDtFechamento());
        dto.setVlDocumentoFiscal(d.getVlDocumentoFiscal());

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

        return dto;

    }

    public DocumentoFiscalEntity parseToEntity(DFEntradaDTO dto, DocumentoFiscalEntity dfEntity) throws Exception {
        if (dfEntity == null)
            dfEntity = new DocumentoFiscalEntity();

        if (dto == null)
            return dfEntity;


        dfEntity.setOperacao(operacaoRepository.getOne(dto.getOperacao().getCdOperacao()));
        dfEntity.setFilial(filialRepository.getOne(dto.getIdFilial()));
        dfEntity.setFornecedor(fornecedorRepository.getOne(dto.getIdFornecedor()));
        dfEntity.setNrChaveAcesso(dto.getChaveAcesso());
        dfEntity.setNrNf(dto.getNrNF());
        dfEntity.setNrSerie(dto.getNrSerie());

        dfEntity.setDtEmissao(java.sql.Date.valueOf(formataDataEnviaBD(dto.getEmissao())));
        dfEntity.setDtEntrada(java.sql.Date.valueOf(formataDataEnviaBD(dto.getEntrada())));
        dfEntity.setVlDocumentoFiscal(dto.getVlDocumentoFiscal());

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();
        for (ItensDfDTO itemDTO : dto.getItens()) {
            DocumentoItemEntity itEntity = new DocumentoItemEntity();

            itEntity.setNrItemDocumento(itemDTO.getNrItemDocumento());
            itEntity.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
            itEntity.setQtItem(itemDTO.getQtItem());

            List<ProdutoFilialEstoqueEntity> estoques = produtoFilialEstoqueRepository.findByFilialCdFilialAndProdutoCodigo(dto.getIdFilial(), itemDTO.getCdProduto());

            if (estoques != null && estoques.size() > 0) {
                ProdutoFilialEstoqueEntity estoque = estoques.get(0);
                estoque.setQt_estoque(estoque.getQt_estoque() + itEntity.getQtItem());
                estoque.setQt_empenho(0);
                produtoFilialEstoqueRepository.save(estoque);
            } else {
                ProdutoFilialEstoqueEntity estoque = new ProdutoFilialEstoqueEntity();
                estoque.setFilial(filialRepository.getOne(dto.getIdFilial()));
                estoque.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
                estoque.setQt_estoque(itEntity.getQtItem());
                estoque.setQt_empenho(0);
                produtoFilialEstoqueRepository.save(estoque);
            }

            itEntity.setNf(dfEntity);
            itemsEntity.add(itEntity);
        }
        dfEntity.setItens(itemsEntity);


        return dfEntity;
    }

    public String formataDataEnviaBD(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d = df.parse(data);
        df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(d);
        return s;
    }


}
