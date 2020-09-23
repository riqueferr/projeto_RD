package br.com.pi.projeto_RD.service;


import br.com.pi.projeto_RD.model.dto.BuscarProdutosDTO;
import br.com.pi.projeto_RD.model.dto.FornecedorProdutoDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.StatusProdutoDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.SubCategoriaEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import br.com.pi.projeto_RD.repository.ProdutoPageRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoPageRepository pageRepository;

    @Autowired
    private ProdutoBO produtoBO;

    @PersistenceContext
    private EntityManager manager;

//    public List<ProdutoDto> listarTodas() {
//
//        List<ProdutoDto> listDTO = new ArrayList<>();
//        for (ProdutoEntity entity : repository.findAll()) {
//            ProdutoDto dto = produtoBO.parseToDTO(entity);
//            listDTO.add(dto);
//        }
//
//        return listDTO;
//    }

    public List<ProdutoDto> listarTodasPage(Integer page) {

        Pageable firstPageWithTwoElements = PageRequest.of(page, 2);

        Page<ProdutoEntity> produtoEntityPagentity = pageRepository.findAll(firstPageWithTwoElements);

        List<ProdutoDto> listDTO = new ArrayList<>();
        for (ProdutoEntity entity : produtoEntityPagentity) {
            ProdutoDto dto = produtoBO.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public ProdutoDto buscarPorId(BigInteger codigo) {
        return produtoBO.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoEntity> buscarNfPornmProduto(String Nm_Fantasia) {
        return manager.createNamedQuery("buscarNfPornmProduto", ProdutoEntity.class).setParameter("NM_FANTASIA", Nm_Fantasia).getResultList();
    }


    public List<ProdutoDto> listarTodas() {
        Map<BigInteger, ProdutoDto> map = new HashMap<>();

        Query query = manager.createNativeQuery("SELECT P.CD_PRODUTO, P.NM_FANTASIA, F.CD_FORNECEDOR, " +
                "F.NM_RAZAO_SOCIAL, S.ID_STATUS_PRODUTO, " +
                "S.DS_STATUS_PRODUTO, SC.ID_SUB_CATEGORIA, SC.DS_SUB_CATEGORIA, TP.ID_TIPO_PRODUTO, " +
                "TP.DS_TIPO_PRODUTO, P.NM_FABRICANTE, P.VL_UNIDADE, P.DS_PRODUTO FROM TB_PRODUTO P " +
                "LEFT OUTER JOIN TB_FORNECEDOR_PRODUTO FP ON P.CD_PRODUTO = FP.CD_PRODUTO " +
                "LEFT OUTER JOIN TB_FORNECEDOR F ON FP.CD_FORNECEDOR = F.CD_FORNECEDOR " +
                "LEFT OUTER JOIN TB_STATUS_PRODUTO S ON P.ID_STATUS_PRODUTO = S.ID_STATUS_PRODUTO " +
                "LEFT OUTER JOIN TB_SUB_CATEGORIA_PRODUTO SC ON P.ID_SUB_CATEGORIA = SC.ID_SUB_CATEGORIA " +
                "LEFT OUTER JOIN TB_TIPO_PRODUTO TP ON  P.ID_TIPO_PRODUTO = TP.ID_TIPO_PRODUTO");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoDto dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoDto();
                dto.setCodigo((BigInteger) produto[0]);

                dto.setNm_fantasia( (String) produto [1]);

                //FORNECEDOR
                FornecedorProdutoDTO fornecedorProdutoDTO = new FornecedorProdutoDTO();
                fornecedorProdutoDTO.setCd_fornecedor((BigInteger) produto[2]);
                fornecedorProdutoDTO.setNm_razao_social((String) produto[3]);

                //STATUS PRODUTO
                StatusProdutoEntity status = new StatusProdutoEntity();
                status.setIdStatusProduto((BigInteger) produto[4]);
                status.setDsStatusProduto((String) produto[5]);
                dto.setStatusProduto(status);

                //SUB CATEGORIA
                SubCategoriaEntity sc = new SubCategoriaEntity();
                sc.setIdSubCategoria((BigInteger) produto[6]);
                sc.setDsSubCategoria((String) produto[7]);
                dto.setSubCategoria(sc);

                //TIPO PRODUTO
                TipoProdutoEntity tp = new TipoProdutoEntity();
                tp.setIdTipoProduto((BigInteger) produto[8]);
                tp.setDsTipoProduto((String) produto[9]);
                dto.setTipo_produto(tp);

                dto.setNm_fabricante((String) produto[10]);
                dto.setVl_unidade((BigDecimal) produto[11]);
                dto.setDsProduto((String) produto[12]);

                if(dto.getFornecedor() == null)
                    dto.setFornecedor(new ArrayList<>());
                    dto.getFornecedor().add(fornecedorProdutoDTO);

            }else{
                dto = map.get(codigo);
                FornecedorProdutoDTO fornecedorProdutoDTO = new FornecedorProdutoDTO();
                fornecedorProdutoDTO.setCd_fornecedor((BigInteger) produto[2]);
                fornecedorProdutoDTO.setNm_razao_social((String) produto[3]);
                dto.getFornecedor().add(fornecedorProdutoDTO);
            }
            map.put(dto.getCodigo(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<ProdutoDto> listarPorFornecedor(BigInteger fornecedor) {

        Map<BigInteger, ProdutoDto> map = new HashMap<>();
        Query query = manager.createNativeQuery("select P.CD_PRODUTO, P.NM_FANTASIA, F.CD_FORNECEDOR, F.NM_RAZAO_SOCIAL " +
                "from TB_PRODUTO P, TB_FORNECEDOR_PRODUTO FP, TB_FORNECEDOR F " +
                "where P.CD_PRODUTO = FP.CD_PRODUTO " +
                "AND FP.CD_FORNECEDOR = F.CD_FORNECEDOR " +
                "AND F.CD_FORNECEDOR = "+ fornecedor +" " +
                "ORDER BY P.CD_PRODUTO");

        List<Object []> listEntity = query.getResultList();
        for(Object [] produto : listEntity){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            ProdutoDto dto = null;
            if(!map.containsKey(codigo)){
                dto = new ProdutoDto();
                dto.setCodigo((BigInteger) produto[0]);
                dto.setNm_fantasia( (String) produto [1]);

                //FORNECEDOR
                FornecedorProdutoDTO fornecedorProdutoDTO = new FornecedorProdutoDTO();
                fornecedorProdutoDTO.setCd_fornecedor((BigInteger) produto[2]);
                fornecedorProdutoDTO.setNm_razao_social((String) produto[3]);

                if(dto.getFornecedor() == null)
                    dto.setFornecedor(new ArrayList<>());
                dto.getFornecedor().add(fornecedorProdutoDTO);

            }else{
                dto = map.get(codigo);
                FornecedorProdutoDTO fornecedorProdutoDTO = new FornecedorProdutoDTO();
                fornecedorProdutoDTO.setCd_fornecedor((BigInteger) produto[2]);
                fornecedorProdutoDTO.setNm_razao_social((String) produto[3]);
                dto.getFornecedor().add(fornecedorProdutoDTO);
            }
            map.put(dto.getCodigo(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public ProdutoEntity inserir(ProdutoDto dto) throws Exception {
        ProdutoEntity entity = produtoBO.parseToEntity(dto, null);
        if (entity.getNm_fantasia() != null)
            repository.save(entity);
        return entity;
    }

    public void atualizar(ProdutoDto dto) throws Exception {
        ProdutoEntity entity = repository.getOne(dto.getCodigo());
        if (entity != null) {
            entity = produtoBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public ProdutoDto excluirPorId(BigInteger codigo) {
        ProdutoEntity entity = repository.getOne(codigo);
        ProdutoDto dto = new ProdutoDto();

        if (entity != null) {
            dto = produtoBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }


}
