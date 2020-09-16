package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.controller.ResultData;
import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DFTransferenciaBO {

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

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public DFTransferenciaDTO parseToDTO(DocumentoFiscalEntity d) {
        DFTransferenciaDTO dto = new DFTransferenciaDTO();

        if (d == null)
            return dto;

        dto.setIdDocumento(d.getIdDocumento());
        dto.setOperacao(d.getOperacao());

        dto.setIdFilial(d.getFilial().getCdFilial());
        dto.setNmFilial(d.getFilial().getNmFilial());

        if(d.getDestino().getCdFilial() != null) {
            dto.setIdFilialDestino(d.getDestino().getCdFilial());
            dto.setNmFilialDestino(d.getDestino().getNmFilial());
        }

        dto.setChaveAcesso(d.getNrChaveAcesso());
        dto.setNrNF(d.getNrNf());
        dto.setNrSerie(d.getNrSerie());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        dto.setDtEmissao(d.getDtEntrada());
        dto.setDtEntrada(d.getDtEntrada());

        List<ItensDfDTO> itens = new ArrayList<>();
        for (DocumentoItemEntity item : d.getItens()) {
            ItensDfDTO eDTO = new ItensDfDTO();

            eDTO.setNrItemDocumento(item.getNrItemDocumento());

            eDTO.setCdProduto(item.getProduto().getCodigo());
            eDTO.setNmProduto(item.getProduto().getNm_fantasia());
            eDTO.setQtItem(item.getQtItem());

            itens.add(eDTO);

        }
        dto.setItens(itens);

        return dto;

    }

    public DocumentoFiscalEntity parseToEntity(DFTransferenciaDTO dto, DocumentoFiscalEntity dfEntity) throws Exception {
        if (dfEntity == null)
            dfEntity = new DocumentoFiscalEntity();

        if (dto == null)
            return dfEntity;


        dfEntity.setOperacao(operacaoRepository.getOne(dto.getOperacao().getCdOperacao()));
        dfEntity.setFilial(filialRepository.getOne(dto.getIdFilial()));
        dfEntity.setDestino(filialRepository.getOne(dto.getIdFilialDestino()));


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
            ProdutoFilialEstoqueEntity estoqueNulo = estoques.get(0);

            if (estoqueNulo.getQt_estoque() <= 0) {
//                ResultData resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Estoque vazio!");
                return null;
            } else {

                //DECREMENTO NA FILIAL ORIGEM
                if (estoques != null && estoques.size() > 0) {
                    ProdutoFilialEstoqueEntity estoque = estoques.get(0);
                    estoque.setQt_estoque(estoque.getQt_estoque() - itEntity.getQtItem());
                    produtoFilialEstoqueRepository.save(estoque);
                }

                //INCREMENTO NA FILIAL DESTINO
                List<ProdutoFilialEstoqueEntity> estoquesDestino = produtoFilialEstoqueRepository.findByFilialCdFilialAndProdutoCodigo(dto.getIdFilialDestino(), itemDTO.getCdProduto());

                if (estoquesDestino != null && estoquesDestino.size() > 0) {
                    ProdutoFilialEstoqueEntity estoqueDestino = estoquesDestino.get(0);
                    estoqueDestino.setQt_estoque(estoqueDestino.getQt_estoque() + itEntity.getQtItem());
                    estoqueDestino.setQt_empenho(0);
                    produtoFilialEstoqueRepository.save(estoqueDestino);
                } else {
                    ProdutoFilialEstoqueEntity estoque = new ProdutoFilialEstoqueEntity();
                    estoque.setFilial(filialRepository.getOne(dto.getIdFilialDestino()));
                    estoque.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
                    estoque.setQt_estoque(itEntity.getQtItem());
                    estoque.setQt_empenho(0);
                    produtoFilialEstoqueRepository.save(estoque);
                }
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
