package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.*;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import br.com.pi.projeto_RD.service.bo.DFEntradaBO;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
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
public class DFEntradaService {

    @Autowired
    private DFEntradaBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    @PersistenceContext
    private EntityManager manager;

//    public List<DFEntradaDTO> buscarTodos() {
//        List<DocumentoFiscalEntity> dfEntity = repository.findByOperacaoDsOperacao("ENTRADA");
//        List<DFEntradaDTO> entradaDTO = new ArrayList<>();
//
//        for (DocumentoFiscalEntity entity : dfEntity) {
//            DFEntradaDTO dto = bo.parseToDTO(entity);
//            entradaDTO.add(dto);
//        }
//        return entradaDTO;
//    }

    public List<DFEntradaDTO> buscarTodos() {
        Map<Integer, DFEntradaDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DC.ID_DOCUMENTO_FISCAL, O.CD_OPERACAO, O.DS_OPERACAO, F.CD_FILIAL, " +
                "F.NM_FILIAL, FO.CD_FORNECEDOR, FO.NM_RAZAO_SOCIAL, DC.NR_CHAVE_ACESSO, " +
                "DC.NR_NF, DC.NR_SERIE, DC.DT_EMISSAO, DC.DT_ENTRADA, DC.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM " +
                "FROM TB_DOCUMENTO_FISCAL DC " +
                "LEFT OUTER JOIN TB_OPERACAO O ON DC.CD_OPERACAO = O.CD_OPERACAO " +
                "LEFT OUTER JOIN TB_FILIAL F ON DC.CD_FILIAL = F.CD_FILIAL " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON DC.ID_FORNECEDOR = FO.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_DOCUMENTO_ITEM DI ON DC.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "LEFT OUTER JOIN TB_PRODUTO P ON DI.CD_PRODUTO = P.CD_PRODUTO " +
                "WHERE O.DS_OPERACAO = 'ENTRADA'");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DFEntradaDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DFEntradaDTO();
                dto.setIdDocumento((BigInteger) produto[0]);

                //OPERAÇÃO
                OperacaoEntity o = new OperacaoEntity();
                o.setCdOperacao((BigInteger) produto[1]);
                o.setDsOperacao((String) produto[2]);
                dto.setOperacao(o);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[3]);
                dto.setNmFilial((String) produto[4]);

                //FORNECEDOR
                dto.setIdFornecedor((BigInteger) produto[5]);
                dto.setNmFornecedor((String) produto[6]);

                dto.setChaveAcesso((BigInteger) produto[7]);
                dto.setNrNF((BigInteger) produto[8]);
                dto.setNrSerie((BigInteger) produto[9]);
                dto.setDtEmissao((Date) produto[10]);
                dto.setDtEntrada((Date) produto[11]);
                dto.setVlDocumentoFiscal((BigDecimal) produto[12]);

                //ITENS
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[13]);
                itensDfDTO.setCdProduto((BigInteger) produto[14]);
                itensDfDTO.setNmProduto((String) produto[15]);
                itensDfDTO.setQtItem((Integer) produto[16]);

                if(dto.getItens() == null)
                    dto.setItens(new ArrayList<>());
                dto.getItens().add(itensDfDTO);

            }else{
                dto = map.get(codigo);
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[13]);
                itensDfDTO.setCdProduto((BigInteger) produto[14]);
                itensDfDTO.setNmProduto((String) produto[15]);
                itensDfDTO.setQtItem((Integer) produto[16]);
                dto.getItens().add(itensDfDTO);
            }
            map.put(dto.getIdDocumento().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public DFEntradaDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<DFEntradaDTO> buscarPorFilial(String filial) {
        Map<Integer, DFEntradaDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DC.ID_DOCUMENTO_FISCAL, O.CD_OPERACAO, O.DS_OPERACAO, F.CD_FILIAL, " +
                "F.NM_FILIAL, FO.CD_FORNECEDOR, FO.NM_RAZAO_SOCIAL, DC.NR_CHAVE_ACESSO, " +
                "DC.NR_NF, DC.NR_SERIE, DC.DT_EMISSAO, DC.DT_ENTRADA, DC.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM " +
                "FROM TB_DOCUMENTO_FISCAL DC, TB_OPERACAO O, TB_FILIAL F, TB_FORNECEDOR FO, " +
                "TB_DOCUMENTO_ITEM DI, TB_PRODUTO P " +
                "WHERE DC.CD_OPERACAO = O.CD_OPERACAO " +
                "AND DC.CD_FILIAL = F.CD_FILIAL " +
                "AND DC.ID_FORNECEDOR = FO.CD_FORNECEDOR " +
                "AND DC.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "AND DI.CD_PRODUTO = P.CD_PRODUTO " +
                "AND O.DS_OPERACAO = 'ENTRADA'" +
                "AND F.NM_FILIAL = '"+ filial +"'");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DFEntradaDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DFEntradaDTO();
                dto.setIdDocumento((BigInteger) produto[0]);

                //OPERAÇÃO
                OperacaoEntity o = new OperacaoEntity();
                o.setCdOperacao((BigInteger) produto[1]);
                o.setDsOperacao((String) produto[2]);
                dto.setOperacao(o);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[3]);
                dto.setNmFilial((String) produto[4]);

                //FORNECEDOR
                dto.setIdFornecedor((BigInteger) produto[5]);
                dto.setNmFornecedor((String) produto[6]);

                dto.setChaveAcesso((BigInteger) produto[7]);
                dto.setNrNF((BigInteger) produto[8]);
                dto.setNrSerie((BigInteger) produto[9]);
                dto.setDtEmissao((Date) produto[10]);
                dto.setDtEntrada((Date) produto[11]);
                dto.setVlDocumentoFiscal((BigDecimal) produto[12]);

                //ITENS
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[13]);
                itensDfDTO.setCdProduto((BigInteger) produto[14]);
                itensDfDTO.setNmProduto((String) produto[15]);
                itensDfDTO.setQtItem((Integer) produto[16]);

                if(dto.getItens() == null)
                    dto.setItens(new ArrayList<>());
                dto.getItens().add(itensDfDTO);

            }else{
                dto = map.get(codigo);
                ItensDfDTO itensDfDTO = new ItensDfDTO();
                itensDfDTO.setNrItemDocumento((BigInteger) produto[13]);
                itensDfDTO.setCdProduto((BigInteger) produto[14]);
                itensDfDTO.setNmProduto((String) produto[15]);
                itensDfDTO.setQtItem((Integer) produto[16]);
                dto.getItens().add(itensDfDTO);
            }
            map.put(dto.getIdDocumento().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public DocumentoFiscalEntity inserir(DFEntradaDTO dto) throws Exception {
        DocumentoFiscalEntity entity = bo.parseToEntity(dto, null);
        if (entity.getVlDocumentoFiscal() != null)
            repository.save(entity);
        return entity;
    }


}
