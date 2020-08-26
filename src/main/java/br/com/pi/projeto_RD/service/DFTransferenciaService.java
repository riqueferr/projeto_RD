package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.DFTransferenciaDTO;
import br.com.pi.projeto_RD.model.dto.ItensDfDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.DocumentoItemEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.OperacaoRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.DFTransferenciaBO;
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

    @Autowired
    private DFTransferenciaBO bo;

    @PersistenceContext
    private EntityManager manager;


    public List<DFTransferenciaDTO> buscarTodos() {
        List<DocumentoFiscalEntity> dfEntity = repository.findByOperacaoDsOperacao("TRANSFERENCIA");
        List<DFTransferenciaDTO> transferenciaDTO = new ArrayList<>();

        for (DocumentoFiscalEntity entity : dfEntity) {
            DFTransferenciaDTO dto = bo.parseToDTO(entity);
            transferenciaDTO.add(dto);
        }
        return transferenciaDTO;
    }

    public DocumentoFiscalEntity inserir(DFTransferenciaDTO dto) throws Exception {
        DocumentoFiscalEntity entity = bo.parseToEntity(dto, null);
        if (entity.getFilial() != null){
            repository.save(entity);
            }
        return entity;
    }


}
