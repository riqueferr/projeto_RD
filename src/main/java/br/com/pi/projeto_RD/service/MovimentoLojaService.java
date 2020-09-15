package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.*;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.MovimentoLojaBO;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovimentoLojaService {

    @Autowired
    private MovimentoLojaBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private EntityManager manager;

    public List<MovimentoLojaDTO> buscarTodos() {
//        List<DocumentoFiscalEntity> dfEntity = repository.findAll();
//        List<MovimentoLojaDTO> movimentoDTO = new ArrayList<>();
//
//
//        for (DocumentoFiscalEntity entity : dfEntity) {
//            MovimentoLojaDTO dto = bo.parseToDTO(entity);
//            movimentoDTO.add(dto);
//        }
//        return movimentoDTO;
        Map<Integer, MovimentoLojaDTO> map = new HashMap<>();

        javax.persistence.Query query = manager.createNativeQuery("SELECT DISTINCT\n" +
                "                F.CD_FILIAL,\n" +
                "                F.NM_FILIAL, DF.DT_ENTRADA,\n" +
                "                DF.ID_DOCUMENTO_FISCAL,\n" +
                "                SUM(DF.VL_DOCUMENTO_FISCAL) as Soma\n" +
                "                FROM TB_DOCUMENTO_FISCAL DF \n" +
                "                LEFT OUTER JOIN TB_FILIAL F ON DF.CD_FILIAL = F.CD_FILIAL \n" +
                "                LEFT OUTER JOIN TB_PAGAMENTO_DOC PD ON DF.ID_DOCUMENTO_FISCAL = PD.ID_DOCUMENTO_FISCAL \n" +
                "                WHERE PD.ID_TIPO_PAGAMENTO = 4 OR PD.ID_TIPO_PAGAMENTO = 5\n" +
                "                GROUP BY PD.ID_TIPO_PAGAMENTO;");

        List<Object[]> listentity = query.getResultList();
        for(Object [] produto : listentity ){
            Integer codigo = ((BigInteger) produto [0]).intValue();
            MovimentoLojaDTO dto = null;
            DocumentoFiscalEntity entity = new DocumentoFiscalEntity();
            if (!map.containsKey(codigo)) {
                dto = new MovimentoLojaDTO();

                //Filial

                dto.setCdFilial((BigInteger) produto[0]);
                dto.setNmFilial((String) produto[1]);


                //Documento Fiscal
                dto.setDtEntrada((Date) produto[2]);
                dto.setVlDocumento((BigDecimal) produto[4]);
                dto.setIdDocumento((BigInteger) produto[3]);







            }
            map.put(dto.getIdDocumento().intValue(), dto);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<PagamentoDocEntity> buscarPagamento(Date dtEntrada){


        return manager.createNamedQuery("buscarTiposPagamento", PagamentoDocEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).getResultList();

    }

    public List<DocumentoFiscalEntity> buscarData(Date dtEntrada){
        return manager.createNamedQuery("buscarNfPorDataEntrada", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).getResultList();
    }

    public List<PagamentoDocEntity> buscarPagamentoDinheiro(){

        return manager.createNamedQuery("buscarTipoDinheiro", PagamentoDocEntity.class).getResultList();
    }

    public List<PagamentoDocEntity> buscarPagamentoCheque(){

        return manager.createNamedQuery("buscarTipoCheque", PagamentoDocEntity.class).getResultList();
    }

    public List<MovimentoLojaDTO> buscarTeste(Date dtEntrada, Long filial){

//        List<DocumentoFiscalEntity> list = manager.createNamedQuery("filtrarDataeFilial", DocumentoFiscalEntity.class).setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial).getResultList();
//        List<MovimentoLojaDTO> dtoList = new ArrayList<>();
//        for (DocumentoFiscalEntity entity : list){
//            dtoList.add(new MovimentoLojaDTO(entity.getIdDocumento(),entity.getDtEntrada(), entity.getVlDocumentoFiscal(),entity.getFilial()));
//        }
//        return dtoList;
        return null;
    }

    public Double somarDinheiro(Date dtEntrada, Long filial){
        Query query = (Query) manager.createQuery("Select sum(p.vlPagamento) from DocumentoFiscalEntity n  JOIN n.pagamento p where p.tipoPagamento.idTipoPagamento = 4 AND n.dtEntrada = :DT_ENTRADA AND n.filial.cdFilial = :FILIAL", Double.class);
        query.setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial);

        return (Double) query.getSingleResult();
    }

    public Double somarCheque(Date dtEntrada, Long filial){
        Query query = (Query) manager.createQuery("Select sum(p.vlPagamento) from DocumentoFiscalEntity n  JOIN n.pagamento p where p.tipoPagamento.idTipoPagamento = 5 AND n.dtEntrada = :DT_ENTRADA AND n.filial.cdFilial = :FILIAL", Double.class);
        query.setParameter("DT_ENTRADA", dtEntrada, TemporalType.DATE).setParameter("FILIAL", filial);

        return (Double) query.getSingleResult();
    }



}
