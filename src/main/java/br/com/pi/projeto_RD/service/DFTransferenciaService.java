package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.OperacaoRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DFTransferenciaService {

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PersistenceContext
    private EntityManager manager;

    public List<DFTransferenciaDTO> listarTodas() {

        List<DFTransferenciaDTO> listaDTO = new ArrayList<>();
        List<DocumentoFiscalEntity> listaEntity = repository.findAll();

        for (DocumentoFiscalEntity nf : listaEntity) {
            DFTransferenciaDTO dto = new DFTransferenciaDTO();
            dto.setIdDocumentoFiscal(nf.getIdDocumento());
            dto.setOperacao(nf.getOperacao());

            dto.setIdFilial(nf.getFilial().getCd_filial());
            dto.setNmFilial(nf.getFilial().getNm_filial());

//            dto.setIdFilialDestino(nf.getFilialDestino().getCd_filial());
//            dto.setNmFilialDestino(nf.getFilialDestino().getNm_filial());

            dto.setChaveAcesso(nf.getNrChaveAcesso());
            dto.setNrNF(nf.getNrNf());
            dto.setNrSerie(nf.getNrSerie());
            dto.setDtEmissao(nf.getDtEmissao());
            dto.setDtEntrada(nf.getDtEntrada());

            List<ItensDfDTO> itens = new ArrayList<>();

            for (DocumentoItemEntity item : nf.getItens()) {
                ItensDfDTO itDTO = new ItensDfDTO();
//                itDTO.setIdNf(item.gtIdNf());

                itDTO.setCdProduto(item.getProduto().getCodigo());
                itDTO.setNrItemDocumento(item.getNrItemDocumento());
//                itDTO.setNmProduto(item.getProduto().getNm_fantasia());
                itDTO.setQtItem(item.getQtItem());
                itDTO.setVlItem(item.getVlItem());
                itDTO.setPcIcms(item.getPcIcms());
                itDTO.setVlIcms(item.getVlIcms());

                itens.add(itDTO);
            }

            dto.setItens(itens);
            listaDTO.add(dto);
        }

        return listaDTO;
    }

    public DocumentoFiscalEntity inserir(DFTransferenciaDTO nfDTO) throws Exception {


        FilialEntity filial = filialRepository.getOne(nfDTO.getIdFilial());
        if (filial == null)
            throw new Exception("cdFilial: " + nfDTO.getIdFilial() + " não encontrado!");

        DocumentoFiscalEntity nfEntity = new DocumentoFiscalEntity();

        nfEntity.setIdDocumento(nfDTO.getIdDocumentoFiscal());
        nfEntity.setOperacao(operacaoRepository.getOne(nfDTO.getOperacao().getCdOperacao()));
        nfEntity.setFilial(filial);

        nfEntity.setNrChaveAcesso(nfDTO.getChaveAcesso());
        nfEntity.setNrNf(nfDTO.getNrNF());
        nfEntity.setNrSerie(nfDTO.getNrSerie());
        nfEntity.setDtEmissao(nfDTO.getDtEmissao());
        nfEntity.setDtEntrada(nfDTO.getDtEntrada());


        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();
        for (ItensDfDTO itemDTO : nfDTO.getItens()) {
            DocumentoItemEntity itEntity = new DocumentoItemEntity();

            itEntity.setNrItemDocumento(itemDTO.getNrItemDocumento());
            itEntity.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
            itEntity.setQtItem(itemDTO.getQtItem());
            itEntity.setVlItem(itemDTO.getVlItem());
            itEntity.setPcIcms(itemDTO.getPcIcms());
            itEntity.setVlIcms(itemDTO.getVlIcms());

            itemsEntity.add(itEntity);
        }

        nfEntity.setItens(itemsEntity);

        return repository.save(nfEntity);
    }


}
