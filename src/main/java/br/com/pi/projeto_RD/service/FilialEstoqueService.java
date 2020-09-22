package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
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
public class FilialEstoqueService {

    @Autowired
    private ProdutoFilialEstoqueBO pfBO;

    @Autowired
    private ProdutoFilialEstoqueRepository repository;



    @PersistenceContext
    private EntityManager manager;

//    public List<ProdutoFilialEstoqueDTO> buscarTodos() {
//        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findAll();
//        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();
//
//
//        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
//            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
//            filialDTO.add(dto);
//        }
//        return filialDTO;
//    }

    public List<ProdutoFilialEstoqueDTO> buscarTodos() {
        Map<Integer, ProdutoFilialEstoqueDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT PE.CD_ESTOQUE, FI.CD_FILIAL, FI.NM_FILIAL, PR.CD_PRODUTO, " +
                "PR.NM_FANTASIA, SC.DS_SUB_CATEGORIA, PE.QT_ESTOQUE, PE.QT_BASE " +
                "FROM TB_PRODUTO_FILIAL_ESTOQUE PE " +
                "LEFT OUTER JOIN TB_PRODUTO PR ON PR.CD_PRODUTO = PE.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_SUB_CATEGORIA_PRODUTO SC ON SC.ID_SUB_CATEGORIA = PR.ID_SUB_CATEGORIA " +
                "LEFT OUTER JOIN TB_FILIAL FI ON FI.CD_FILIAL = PE.CD_FILIAL " +
                "ORDER BY PR.CD_PRODUTO");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoFilialEstoqueDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoFilialEstoqueDTO();
                dto.setCdEstoque((BigInteger) produto[0]);

                //FILIAL
                dto.setCdFilial((BigInteger) produto[1]);
                dto.setNmFilial((String) produto[2]);


                //PRODUTO
                dto.setCdProduto((BigInteger) produto[3]);
                dto.setNmProduto((String) produto[4]);

                //SUB CATEGORIA
                dto.setSubCategoria((String) produto[5]);

                //QTDE ESTOQUE
                dto.setQt_estoque((Integer) produto[6]);

                //QTDE BASE
                dto.setQt_base((Integer) produto[7]);


           }
            map.put(dto.getCdEstoque().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<ProdutoFilialEstoqueDTO> buscarFilialProduto(Integer idFilial) {
        Map<Integer, ProdutoFilialEstoqueDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT FE.CD_ESTOQUE, F.CD_FILIAL, F.NM_FILIAL, P.CD_PRODUTO, P.NM_FANTASIA, FE.QT_ESTOQUE " +
                "FROM TB_PRODUTO_FILIAL_ESTOQUE FE " +
                "LEFT OUTER JOIN TB_FILIAL F ON F.CD_FILIAL = FE.CD_FILIAL " +
                "LEFT OUTER JOIN TB_PRODUTO P ON P.CD_PRODUTO = FE.CD_PRODUTO " +

                " WHERE F.CD_FILIAL = "+ idFilial + "");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoFilialEstoqueDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoFilialEstoqueDTO();
                dto.setCdEstoque((BigInteger) produto[0]);

                //FILIAL
                dto.setCdFilial((BigInteger) produto[1]);
                dto.setNmFilial((String) produto[2]);

                //PRODUTO
                dto.setCdProduto((BigInteger) produto[3]);
                dto.setNmProduto((String) produto[4]);

                dto.setQt_estoque((Integer) produto[5]);


            }
            map.put(dto.getCdEstoque().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public ProdutoFilialEstoqueDTO buscarPorId(BigInteger codigo) {
        return pfBO.parseToDTO(repository.getOne(codigo));
    }

//    public List<ProdutoFilialEstoqueDTO> buscarCdFilial(Long cdFilial) {
//        List<ProdutoFilialEstoqueEntity> pfEntity = repository.findByFilialCdFilial(cdFilial);
//        List<ProdutoFilialEstoqueDTO> filialDTO = new ArrayList<>();
//        for (ProdutoFilialEstoqueEntity entity : pfEntity) {
//            ProdutoFilialEstoqueDTO dto = pfBO.parseToDTO(entity);
//            filialDTO.add(dto);
//        }
//        return filialDTO;
//    }

    public List<ProdutoFilialEstoqueDTO> buscarCdFilial(Long cdFilial) {
        Map<Integer, ProdutoFilialEstoqueDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT PE.CD_ESTOQUE, FI.CD_FILIAL, FI.NM_FILIAL, PR.CD_PRODUTO, " +
                "PR.NM_FANTASIA, SC.DS_SUB_CATEGORIA, PE.QT_ESTOQUE, PE.QT_BASE " +
                "FROM TB_PRODUTO_FILIAL_ESTOQUE PE " +
                "LEFT OUTER JOIN TB_PRODUTO PR ON PR.CD_PRODUTO = PE.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_SUB_CATEGORIA_PRODUTO SC ON SC.ID_SUB_CATEGORIA = PR.ID_SUB_CATEGORIA " +
                "LEFT OUTER JOIN TB_FILIAL FI ON FI.CD_FILIAL = PE.CD_FILIAL " +
                " WHERE FI.CD_FILIAL = "+ cdFilial + "");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoFilialEstoqueDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoFilialEstoqueDTO();
                dto.setCdEstoque((BigInteger) produto[0]);

                //FILIAL
                dto.setCdFilial((BigInteger) produto[1]);
                dto.setNmFilial((String) produto[2]);


                //PRODUTO
                dto.setCdProduto((BigInteger) produto[3]);
                dto.setNmProduto((String) produto[4]);

                //SUB CATEGORIA
                dto.setSubCategoria((String) produto[5]);

                //QTDE ESTOQUE
                dto.setQt_estoque((Integer) produto[6]);

                //QTDE BASE
                dto.setQt_base((Integer) produto[7]);


            }
            map.put(dto.getCdEstoque().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }


    public List<ProdutoFilialEstoqueDTO> buscarNmFilial(String NM_FILIAL) {
        Map<Integer, ProdutoFilialEstoqueDTO> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT PE.CD_ESTOQUE, FI.CD_FILIAL, FI.NM_FILIAL, PR.CD_PRODUTO, " +
                "PR.NM_FANTASIA, SC.DS_SUB_CATEGORIA, PE.QT_ESTOQUE, PE.QT_BASE " +
                "FROM TB_PRODUTO_FILIAL_ESTOQUE PE " +
                "LEFT OUTER JOIN TB_PRODUTO PR ON PR.CD_PRODUTO = PE.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_SUB_CATEGORIA_PRODUTO SC ON SC.ID_SUB_CATEGORIA = PR.ID_SUB_CATEGORIA " +
                "LEFT OUTER JOIN TB_FILIAL FI ON FI.CD_FILIAL = PE.CD_FILIAL " +
                "WHERE FI.NM_FILIAL LIKE'%"+ NM_FILIAL +"%'");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoFilialEstoqueDTO dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoFilialEstoqueDTO();
                dto.setCdEstoque((BigInteger) produto[0]);

                //FILIAL
                dto.setCdFilial((BigInteger) produto[1]);
                dto.setNmFilial((String) produto[2]);


                //PRODUTO
                dto.setCdProduto((BigInteger) produto[3]);
                dto.setNmProduto((String) produto[4]);

                //SUB CATEGORIA
                dto.setSubCategoria((String) produto[5]);

                //QTDE ESTOQUE
                dto.setQt_estoque((Integer) produto[6]);

                //QTDE BASE
                dto.setQt_base((Integer) produto[7]);


            }
            map.put(dto.getCdEstoque().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public ProdutoFilialEstoqueEntity inserir(ProdutoFilialEstoqueDTO dto) throws Exception {
        ProdutoFilialEstoqueEntity entity = pfBO.parseToEntity(dto, null);

        if (entity.getQt_estoque() != null)
            repository.save(entity);
        return entity;
    }

    public void atualizar(ProdutoFilialEstoqueDTO dto) throws Exception {
        ProdutoFilialEstoqueEntity entity = repository.getOne(dto.getCdEstoque());
        if (entity != null) {
            entity = pfBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

}
