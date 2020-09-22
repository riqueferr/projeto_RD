package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.OperacaoRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.DFTransferenciaBO;
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
public class DFTransferenciaService {

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DFTransferenciaBO bo;

    @PersistenceContext
    private EntityManager manager;

    public List<DFTransferenciaDTO> buscarTodos() {
        Map<Integer, DFTransferenciaDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DISTINCT DC.ID_DOCUMENTO_FISCAL, O.CD_OPERACAO, O.DS_OPERACAO, " +
                "DC.CD_FILIAL_DESTINO, FD.NM_FILIAL AS NM_FILIAL_DESTINO, F.CD_FILIAL, F.NM_FILIAL, DC.NR_CHAVE_ACESSO, " +
                "DC.NR_NF, DC.NR_SERIE, DC.DT_EMISSAO, DC.DT_ENTRADA, DC.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM " +
                "FROM TB_DOCUMENTO_FISCAL DC, TB_OPERACAO O, TB_FILIAL F, TB_FILIAL FD, TB_FORNECEDOR FO, " +
                "TB_DOCUMENTO_ITEM DI, TB_PRODUTO P " +
                "WHERE DC.CD_OPERACAO = O.CD_OPERACAO " +
                "AND DC.CD_FILIAL = F.CD_FILIAL " +
                "AND DC.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "AND DI.CD_PRODUTO = P.CD_PRODUTO " +
                "AND DC.CD_FILIAL_DESTINO = FD.CD_FILIAL " +
                "AND O.DS_OPERACAO = 'TRANSFERENCIA'");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DFTransferenciaDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DFTransferenciaDTO();
                dto.setIdDocumento((BigInteger) produto[0]);

                //OPERAÇÃO
                OperacaoEntity o = new OperacaoEntity();
                o.setCdOperacao((BigInteger) produto[1]);
                o.setDsOperacao((String) produto[2]);
                dto.setOperacao(o);

                dto.setIdFilialDestino((BigInteger) produto[3]);
                dto.setNmFilialDestino((String) produto[4]);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[5]);
                dto.setNmFilial((String) produto[6]);

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

//    public List<DFTransferenciaDTO> buscarPorFilial(String filial) {
//        List<DocumentoFiscalEntity> dfEntity = repository.findByOperacaoDsOperacaoAndDestinoNmFilialContaining("TRANSFERENCIA", filial);
//        List<DFTransferenciaDTO> transferenciaDTO = new ArrayList<>();
//
//        for (DocumentoFiscalEntity entity : dfEntity) {
//            DFTransferenciaDTO dto = bo.parseToDTO(entity);
//            transferenciaDTO.add(dto);
//        }
//        return transferenciaDTO;
//    }

    public List<DFTransferenciaDTO> buscarPorFilial(String filial) {
        Map<Integer, DFTransferenciaDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DISTINCT DC.ID_DOCUMENTO_FISCAL, O.CD_OPERACAO, O.DS_OPERACAO, " +
                "DC.CD_FILIAL_DESTINO, FD.NM_FILIAL AS NM_FILIAL_DESTINO, F.CD_FILIAL, F.NM_FILIAL, DC.NR_CHAVE_ACESSO, " +
                "DC.NR_NF, DC.NR_SERIE, DC.DT_EMISSAO, DC.DT_ENTRADA, DC.VL_DOCUMENTO_FISCAL, " +
                "DI.NR_ITEM_DOCUMENTO, DI.CD_PRODUTO, P.NM_FANTASIA, DI.QT_ITEM " +
                "FROM TB_DOCUMENTO_FISCAL DC, TB_OPERACAO O, TB_FILIAL F, TB_FILIAL FD, TB_FORNECEDOR FO, " +
                "TB_DOCUMENTO_ITEM DI, TB_PRODUTO P " +
                "WHERE DC.CD_OPERACAO = O.CD_OPERACAO " +
                "AND DC.CD_FILIAL = F.CD_FILIAL " +
                "AND DC.ID_DOCUMENTO_FISCAL = DI.ID_DOCUMENTO_FISCAL " +
                "AND DI.CD_PRODUTO = P.CD_PRODUTO " +
                "AND DC.CD_FILIAL_DESTINO = FD.CD_FILIAL " +
                "AND O.DS_OPERACAO = 'TRANSFERENCIA' " +
                "AND FD.NM_FILIAL LIKE'%"+ filial +"%'");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            DFTransferenciaDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new DFTransferenciaDTO();
                dto.setIdDocumento((BigInteger) produto[0]);

                //OPERAÇÃO
                OperacaoEntity o = new OperacaoEntity();
                o.setCdOperacao((BigInteger) produto[1]);
                o.setDsOperacao((String) produto[2]);
                dto.setOperacao(o);

                dto.setIdFilialDestino((BigInteger) produto[3]);
                dto.setNmFilialDestino((String) produto[4]);

                //FILIAL
                dto.setIdFilial((BigInteger) produto[5]);
                dto.setNmFilial((String) produto[6]);

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

    public DFTransferenciaDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public DocumentoFiscalEntity inserir(DFTransferenciaDTO dto) throws Exception {
        DocumentoFiscalEntity entity = bo.parseToEntity(dto, null);
        if (entity.getFilial() != null) {
            repository.save(entity);
        }
        return entity;
    }


}
