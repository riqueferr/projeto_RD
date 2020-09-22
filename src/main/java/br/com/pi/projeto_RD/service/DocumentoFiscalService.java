package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.*;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.DocumentoFiscalBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentoFiscalService {

    @Autowired
    private DocumentoFiscalBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @PersistenceContext
    private EntityManager manager;

//    public List<DocumentoFiscalDTO> buscarTodos() {
//        List<DocumentoFiscalEntity> dfEntity = repository.findAll();
//        List<DocumentoFiscalDTO> dfDTO = new ArrayList<>();
//
//        for (DocumentoFiscalEntity entity : dfEntity) {
//            DocumentoFiscalDTO dto = bo.parseToDTO(entity);
//            dfDTO.add(dto);
//        }
//        return dfDTO;
//    }

    public List<DocumentoFiscalDTO> buscarTodos() {
        Map<Integer, DocumentoFiscalDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DF.ID_DOCUMENTO_FISCAL, O.DS_OPERACAO, F.CD_FILIAL, " +
                "F.NM_FILIAL, C.NM_CLIENTE, FO.NM_RAZAO_SOCIAL, M.DS_MOTIVO, " +
                "DF.NR_CHAVE_ACESSO, DF.NR_NF, DF.NR_SERIE, DF.DT_EMISSAO, " +
                "DF.DT_ENTRADA, DF.DT_ABERTURA, DF.DT_FECHAMENTO, DF.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM, " +
                "DI.VL_ITEM, DI.PC_ICMS, DI.VL_ICMS  from TB_DOCUMENTO_FISCAL DF " +
                "LEFT OUTER JOIN TB_CLIENTE C ON DF.ID_CLIENTE = C.ID_CLIENTE " +
                "LEFT OUTER JOIN TB_FILIAL F ON DF.CD_FILIAL = F.CD_FILIAL " +
                "LEFT OUTER JOIN TB_OPERACAO O ON DF.CD_OPERACAO = O.CD_OPERACAO " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON DF.ID_FORNECEDOR = FO.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_MOTIVO M ON DF.ID_MOTIVO = M.ID_MOTIVO " +
                "LEFT OUTER JOIN TB_DOCUMENTO_ITEM DI ON DF.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "LEFT OUTER JOIN TB_PRODUTO P ON DI.CD_PRODUTO = P.CD_PRODUTO");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DocumentoFiscalDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DocumentoFiscalDTO();
                dto.setIdDF((BigInteger) produto[0]);

                //OPERAÇÃO
                dto.setOperacao((String) produto[1]);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[2]);
                dto.setNmFilial((String) produto[3]);

                //CLIENTE
                dto.setCliente((String) produto[4]);

                //FORNECEDOR
                dto.setFornecedor((String) produto[5]);

                //MOTIVO
                MotivoEntity m = new MotivoEntity();
                m.setDsMotivo((String) produto[6]);
                dto.setMotivo(m);

                dto.setNr_chave_acesso((BigInteger) produto[7]);
                dto.setNr_nf((BigInteger) produto[8]);
                dto.setNr_serie((BigInteger) produto[9]);
                dto.setDt_emissao((Date) produto[10]);
                dto.setDt_entrada((Date) produto[11]);
                dto.setDt_abertura((Date) produto[12]);
                dto.setDt_fechamento((Date) produto[13]);
                dto.setVl_documento_fiscal((BigDecimal) produto[14]);

                //ITENS
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[15]);
                itensDfDTO.setCdProduto((BigInteger) produto[16]);
                itensDfDTO.setNmProduto((String) produto[17]);
                itensDfDTO.setQtItem((Integer) produto[18]);
                itensDfDTO.setVlIcms((BigDecimal) produto[19]);
                itensDfDTO.setPcIcms((BigDecimal) produto[20]);
                itensDfDTO.setVlIcms((BigDecimal) produto[21]);

                if(dto.getItens() == null)
                    dto.setItens(new ArrayList<>());
                dto.getItens().add(itensDfDTO);

            }else{
                dto = map.get(codigo);
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[15]);
                itensDfDTO.setCdProduto((BigInteger) produto[16]);
                itensDfDTO.setNmProduto((String) produto[17]);
                itensDfDTO.setQtItem((Integer) produto[18]);
                itensDfDTO.setVlIcms((BigDecimal) produto[19]);
                itensDfDTO.setPcIcms((BigDecimal) produto[20]);
                itensDfDTO.setVlIcms((BigDecimal) produto[21]);
                dto.getItens().add(itensDfDTO);
            }
            map.put(dto.getIdDF().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<TrocaMotivoDTO> filialMotivo() {

        List<DocumentoFiscalEntity> dfEntity = repository.findByMotivoDsMotivo("TROCA");

        List<TrocaMotivoDTO> dfDTO = new ArrayList<>();

//        Big total = 0;

        for (DocumentoFiscalEntity entity : dfEntity) {
            DocumentoFiscalDTO dto = bo.parseToDTO(entity);
//            total = total + entity.getVlDocumentoFiscal();
        }


        for (DocumentoFiscalEntity entity : dfEntity) {
            TrocaMotivoDTO dto = new TrocaMotivoDTO();

            dto.setIdFilial(entity.getFilial().getCdFilial());
            dto.setNmFilial(entity.getFilial().getNmFilial());
//            dto.setTotalTroca(total);
            dfDTO.add(dto);
        }

        return dfDTO;
    }

    public DocumentoFiscalDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<DocumentoFiscalDTO> buscarNfPorFilial(String nmFilial) {
        Map<Integer, DocumentoFiscalDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DF.ID_DOCUMENTO_FISCAL, O.DS_OPERACAO, F.CD_FILIAL, " +
                "F.NM_FILIAL, C.NM_CLIENTE, FO.NM_RAZAO_SOCIAL, M.DS_MOTIVO, " +
                "DF.NR_CHAVE_ACESSO, DF.NR_NF, DF.NR_SERIE, DF.DT_EMISSAO, " +
                "DF.DT_ENTRADA, DF.DT_ABERTURA, DF.DT_FECHAMENTO, DF.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM, " +
                "DI.VL_ITEM, DI.PC_ICMS, DI.VL_ICMS  from TB_DOCUMENTO_FISCAL DF " +
                "LEFT OUTER JOIN TB_CLIENTE C ON DF.ID_CLIENTE = C.ID_CLIENTE " +
                "LEFT OUTER JOIN TB_FILIAL F ON DF.CD_FILIAL = F.CD_FILIAL " +
                "LEFT OUTER JOIN TB_OPERACAO O ON DF.CD_OPERACAO = O.CD_OPERACAO " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON DF.ID_FORNECEDOR = FO.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_MOTIVO M ON DF.ID_MOTIVO = M.ID_MOTIVO " +
                "LEFT OUTER JOIN TB_DOCUMENTO_ITEM DI ON DF.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "LEFT OUTER JOIN TB_PRODUTO P ON DI.CD_PRODUTO = P.CD_PRODUTO " +
                "WHERE F.NM_FILIAL LIKE '%"+ nmFilial +"%' " +
                "ORDER BY DF.ID_DOCUMENTO_FISCAL ASC");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DocumentoFiscalDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DocumentoFiscalDTO();
                dto.setIdDF((BigInteger) produto[0]);

                //OPERAÇÃO
                dto.setOperacao((String) produto[1]);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[2]);
                dto.setNmFilial((String) produto[3]);

                //CLIENTE
                dto.setCliente((String) produto[4]);

                //FORNECEDOR
                dto.setFornecedor((String) produto[5]);

                //MOTIVO
                MotivoEntity m = new MotivoEntity();
                m.setDsMotivo((String) produto[6]);
                dto.setMotivo(m);

                dto.setNr_chave_acesso((BigInteger) produto[7]);
                dto.setNr_nf((BigInteger) produto[8]);
                dto.setNr_serie((BigInteger) produto[9]);
                dto.setDt_emissao((Date) produto[10]);
                dto.setDt_entrada((Date) produto[11]);
                dto.setDt_abertura((Date) produto[12]);
                dto.setDt_fechamento((Date) produto[13]);
                dto.setVl_documento_fiscal((BigDecimal) produto[14]);

                //ITENS
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[15]);
                itensDfDTO.setCdProduto((BigInteger) produto[16]);
                itensDfDTO.setNmProduto((String) produto[17]);
                itensDfDTO.setQtItem((Integer) produto[18]);
                itensDfDTO.setVlIcms((BigDecimal) produto[19]);
                itensDfDTO.setPcIcms((BigDecimal) produto[20]);
                itensDfDTO.setVlIcms((BigDecimal) produto[21]);

                if(dto.getItens() == null)
                    dto.setItens(new ArrayList<>());
                dto.getItens().add(itensDfDTO);

            }else{
                dto = map.get(codigo);
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[15]);
                itensDfDTO.setCdProduto((BigInteger) produto[16]);
                itensDfDTO.setNmProduto((String) produto[17]);
                itensDfDTO.setQtItem((Integer) produto[18]);
                itensDfDTO.setVlIcms((BigDecimal) produto[19]);
                itensDfDTO.setPcIcms((BigDecimal) produto[20]);
                itensDfDTO.setVlIcms((BigDecimal) produto[21]);
                dto.getItens().add(itensDfDTO);
            }
            map.put(dto.getIdDF().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<DocumentoFiscalEntity> buscarNfPorDataEntrada(String dtEntrada) {
        return manager.createNamedQuery("buscarNfPorDataEntrada", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada).getResultList();
    }

    public List<DocumentoFiscalDTO> buscarPorMotivo(String dsMotivo) {
        List<DocumentoFiscalEntity> dfEntity = repository.findByMotivoDsMotivo(dsMotivo);
        List<DocumentoFiscalDTO> dfDTO = new ArrayList<>();

        for (DocumentoFiscalEntity entity : dfEntity) {
            DocumentoFiscalDTO dto = bo.parseToDTO(entity);
            dfDTO.add(dto);
        }
        return dfDTO;
    }


    public DocumentoFiscalDTO excluirPorId(BigInteger idDF) {
        DocumentoFiscalEntity entity = repository.getOne(idDF);
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if (entity != null) {
            dto = bo.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }

}
