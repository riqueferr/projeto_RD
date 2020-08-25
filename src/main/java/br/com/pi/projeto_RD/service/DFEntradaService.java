package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.DFEntradaBO;
import br.com.pi.projeto_RD.service.bo.ProdutoFilialEstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DFEntradaService {

    @Autowired
    private DFEntradaBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    public List<DFEntradaDTO> buscarTodos() {
        List<DocumentoFiscalEntity> dfEntity = repository.findAll();
        List<DFEntradaDTO> entradaDTO = new ArrayList<>();


        for (DocumentoFiscalEntity entity : dfEntity) {
            DFEntradaDTO dto = bo.parseToDTO(entity);
            entradaDTO.add(dto);
        }
        return entradaDTO;
    }

    public DFEntradaDTO buscarPorId(Long codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

    public void atualizar(DFEntradaDTO dto) throws Exception {
        DocumentoFiscalEntity entity = repository.getOne(dto.getIdDocumento());
        if (entity != null) {
            entity = bo.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public DocumentoFiscalEntity inserir(DFEntradaDTO dto) throws Exception {
        DocumentoFiscalEntity entity = bo.parseToEntity(dto, null);
        if (entity.getVlDocumentoFiscal() != null)
            repository.save(entity);
        return entity;
    }

}
