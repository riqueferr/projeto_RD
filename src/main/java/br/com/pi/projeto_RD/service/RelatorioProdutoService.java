package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.RelatorioProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RelatorioProdutoService {

    @Autowired
    private RelatorioProdutoBO bo;

    @Autowired
    private ProdutoRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public List<RelatorioProdutoDTO> listarTodas() {
//        List<ProdutoEntity> listEntity = repository.findAll();
//        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();
//
//        for (ProdutoEntity entity : repository.findAll()) {
//            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
//            listDTO.add(dto);
//        }
//
//        return listDTO;

        Map<Integer, RelatorioProdutoDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DISTINCT P.CD_PRODUTO, P.NM_FANTASIA, TP.DS_TIPO_PRODUTO, " +
                "S.DS_STATUS_PRODUTO, FO.NM_RAZAO_SOCIAL FROM TB_PRODUTO  P " +
                "LEFT OUTER JOIN TB_FORNECEDOR_PRODUTO F ON P.CD_PRODUTO = F.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON FO.CD_FORNECEDOR = F.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_TIPO_PRODUTO TP ON P.ID_TIPO_PRODUTO = TP.ID_TIPO_PRODUTO " +
                "LEFT OUTER JOIN TB_STATUS_PRODUTO S ON P.ID_STATUS_PRODUTO = S.ID_STATUS_PRODUTO");

        List<Object[]> listentity = query.getResultList();
        for(Object [] produto : listentity ){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            RelatorioProdutoDTO dto = null;
            ProdutoEntity entity = new ProdutoEntity();
            if (!map.containsKey(codigo)){
                dto = new RelatorioProdutoDTO();

                //Produto
                dto.setCdProduto((BigInteger) produto[0]);
                dto.setNmProduto((String) produto[1]);
                dto.setStatusProduto((String) produto[2]);
                dto.setTipoProduto((String) produto[3]);


                //Fornecedor
                RelatorioProdutoFornecedorDTO f = new RelatorioProdutoFornecedorDTO();
//                f.setCd_fornecedor((BigInteger) produto[6]);
                f.setNm_razao_social((String) produto[4]);


                if(dto.getFornecedor() == null)
                    dto.setFornecedor(new ArrayList<>());
                dto.getFornecedor().add(f);
            }else{  dto = map.get(codigo);
                RelatorioProdutoFornecedorDTO fDTO = new RelatorioProdutoFornecedorDTO();
                fDTO.setNm_razao_social((String) produto[4]);
                dto.getFornecedor().add(fDTO);
            }
            map.put(dto.getCdProduto().intValue(), dto);


        }
        return map.values().stream().collect(Collectors.toList());
    }

//    public List<RelatorioProdutoDTO> buscarNfPornmProduto(String Nm_Fantasia) {
//
//        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPornmProduto", ProdutoEntity.class).setParameter("NM_FANTASIA", Nm_Fantasia).getResultList();;
//        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();
//
//        for (ProdutoEntity entity : listEntity) {
//            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
//            listDTO.add(dto);
//        }
//
//        return listDTO;
//    }

    public List<RelatorioProdutoDTO> buscarNfPornmProduto(String nmProduto) {

        Map<Integer, RelatorioProdutoDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DISTINCT P.CD_PRODUTO, P.NM_FANTASIA, TP.DS_TIPO_PRODUTO, " +
                "S.DS_STATUS_PRODUTO, FO.NM_RAZAO_SOCIAL FROM TB_PRODUTO  P " +
                "LEFT OUTER JOIN TB_FORNECEDOR_PRODUTO F ON P.CD_PRODUTO = F.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON FO.CD_FORNECEDOR = F.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_TIPO_PRODUTO TP ON P.ID_TIPO_PRODUTO = TP.ID_TIPO_PRODUTO " +
                "LEFT OUTER JOIN TB_STATUS_PRODUTO S ON P.ID_STATUS_PRODUTO = S.ID_STATUS_PRODUTO " +
                "WHERE P.NM_FANTASIA LIKE'%"+ nmProduto +"%'");

        List<Object[]> listentity = query.getResultList();
        for(Object [] produto : listentity ){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            RelatorioProdutoDTO dto = null;
            ProdutoEntity entity = new ProdutoEntity();
            if (!map.containsKey(codigo)){
                dto = new RelatorioProdutoDTO();

                //Produto
                dto.setCdProduto((BigInteger) produto[0]);
                dto.setNmProduto((String) produto[1]);
                dto.setStatusProduto((String) produto[2]);
                dto.setTipoProduto((String) produto[3]);


                //Fornecedor
                RelatorioProdutoFornecedorDTO f = new RelatorioProdutoFornecedorDTO();
//                f.setCd_fornecedor((BigInteger) produto[6]);
                f.setNm_razao_social((String) produto[4]);


                if(dto.getFornecedor() == null)
                    dto.setFornecedor(new ArrayList<>());
                dto.getFornecedor().add(f);
            }else{  dto = map.get(codigo);
                RelatorioProdutoFornecedorDTO fDTO = new RelatorioProdutoFornecedorDTO();
                fDTO.setNm_razao_social((String) produto[4]);
                dto.getFornecedor().add(fDTO);
            }
            map.put(dto.getCdProduto().intValue(), dto);


        }
        return map.values().stream().collect(Collectors.toList());
    }

//    public List<RelatorioProdutoDTO> buscarNfPoridStatusProduto(Long idStatusProduto) {
//
//        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPoridStatusProduto", ProdutoEntity.class).setParameter("ID_STATUS_PRODUTO", idStatusProduto).getResultList();
//        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();
//
//        for (ProdutoEntity entity : listEntity) {
//            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
//            listDTO.add(dto);
//        }
//
//        return listDTO;
//    }

    public RelatorioProdutoDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }


    public List<RelatorioProdutoDTO> buscarNfPoridStatusProduto(BigInteger statusProduto) {

        Map<Integer, RelatorioProdutoDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT DISTINCT P.CD_PRODUTO, P.NM_FANTASIA, TP.DS_TIPO_PRODUTO, " +
                "S.DS_STATUS_PRODUTO, FO.NM_RAZAO_SOCIAL FROM TB_PRODUTO  P " +
                "LEFT OUTER JOIN TB_FORNECEDOR_PRODUTO F ON P.CD_PRODUTO = F.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_FORNECEDOR FO ON FO.CD_FORNECEDOR = F.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_TIPO_PRODUTO TP ON P.ID_TIPO_PRODUTO = TP.ID_TIPO_PRODUTO " +
                "LEFT OUTER JOIN TB_STATUS_PRODUTO S ON P.ID_STATUS_PRODUTO = S.ID_STATUS_PRODUTO " +
                " WHERE S.ID_STATUS_PRODUTO = "+statusProduto+"");

        List<Object[]> listentity = query.getResultList();
        for(Object [] produto : listentity ){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            RelatorioProdutoDTO dto = null;
            ProdutoEntity entity = new ProdutoEntity();
            if (!map.containsKey(codigo)){
                dto = new RelatorioProdutoDTO();

                //Produto
                dto.setCdProduto((BigInteger) produto[0]);
                dto.setNmProduto((String) produto[1]);
                dto.setStatusProduto((String) produto[2]);
                dto.setTipoProduto((String) produto[3]);


                //Fornecedor
                RelatorioProdutoFornecedorDTO f = new RelatorioProdutoFornecedorDTO();
//                f.setCd_fornecedor((BigInteger) produto[6]);
                f.setNm_razao_social((String) produto[4]);


                if(dto.getFornecedor() == null)
                    dto.setFornecedor(new ArrayList<>());
                dto.getFornecedor().add(f);
            }else{  dto = map.get(codigo);
                RelatorioProdutoFornecedorDTO fDTO = new RelatorioProdutoFornecedorDTO();
                fDTO.setNm_razao_social((String) produto[4]);
                dto.getFornecedor().add(fDTO);
            }
            map.put(dto.getCdProduto().intValue(), dto);


        }
        return map.values().stream().collect(Collectors.toList());
    }

}
