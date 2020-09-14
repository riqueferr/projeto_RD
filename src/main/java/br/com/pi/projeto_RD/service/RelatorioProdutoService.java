package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.OperacaoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
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
        List<ProdutoEntity> listEntity = repository.findAll();
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : repository.findAll()) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

//    public List<RelatorioProdutoDTO> buscarTodos() {
//        Map<Integer, RelatorioProdutoDTO> map = new HashMap<>();
//
//        Query query = manager.createNativeQuery("ddddddddddd");
//
//        List<Object []> listEntity = query.getResultList();
//        for(Object [] produto : listEntity){
//            Integer codigo = ((BigInteger) produto [0]).intValue();
//            RelatorioProdutoDTO dto = null;
//            if(!map.containsKey(codigo)){
//                dto = new RelatorioProdutoDTO();
//
//                dto.setCdProduto((BigInteger) produto[0]);
//                dto.setNmProduto((String) produto[1]);
//                dto.setTipoProduto((String) produto[2]);
//                dto.setStatusProduto((String) produto[3]);
//
//                //Fornecedor
//                RelatorioProdutoFornecedorDTO f = new RelatorioProdutoFornecedorDTO();
//                f.setNm_razao_social((String) produto[4]);
//
//                if(dto.getFornecedor() == null)
//                    dto.setFornecedor(new ArrayList<>());
//                dto.getFornecedor().add(f);
//
//            }else{
//                dto = map.get(codigo);
//                RelatorioProdutoFornecedorDTO f = new RelatorioProdutoFornecedorDTO();
//                f.setNm_razao_social((String) produto[4]);
//                dto.getFornecedor().add(f);
//            }
//            map.put(dto.getCdProduto().intValue(), dto);
//        }
//        return map.values().stream().collect(Collectors.toList());
//    }



    public List<RelatorioProdutoDTO> buscarNfPornmProduto(String Nm_Fantasia) {

        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPornmProduto", ProdutoEntity.class).setParameter("NM_FANTASIA", Nm_Fantasia).getResultList();;
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : listEntity) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public List<RelatorioProdutoDTO> buscarNfPoridStatusProduto(Long idStatusProduto) {

        List<ProdutoEntity> listEntity = manager.createNamedQuery("buscarNfPoridStatusProduto", ProdutoEntity.class).setParameter("ID_STATUS_PRODUTO", idStatusProduto).getResultList();
        List<RelatorioProdutoDTO> listDTO = new ArrayList<>();

        for (ProdutoEntity entity : listEntity) {
            RelatorioProdutoDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public RelatorioProdutoDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public List<ProdutoEntity> buscarNfPordsStatusProduto(String dsStatusProduto) {
        return manager.createNamedQuery("buscarNfPordsStatusProduto", ProdutoEntity.class).setParameter("DS_STATUS_PRODUTO", dsStatusProduto).getResultList();
    }

}
