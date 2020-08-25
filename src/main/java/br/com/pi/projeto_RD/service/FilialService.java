package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.DFEntradaDTO;
import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.bo.FilialBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilialService {

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private FilialRepository repository;

    public List<FilialDTO> buscarTodos() {
        List<FilialEntity> filialEntity = repository.findAll();
        List<FilialDTO> filialDTO = new ArrayList<>();


        for (FilialEntity entity : filialEntity) {
            FilialDTO dto = filialBO.parseToDTO(entity);
            filialDTO.add(dto);
        }
        return filialDTO;
    }

    public FilialDTO buscarPorId(Long codigo) {
        return filialBO.parseToDTO(repository.getOne(codigo));
    }

    public void atualizar(FilialDTO dto) throws Exception {
        FilialEntity entity = repository.getOne(dto.getCd_filial());
        if (entity != null) {
            entity = filialBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public FilialEntity inserir(FilialDTO dto) throws Exception {
        FilialEntity entity = filialBO.parseToEntity(dto, null);
        if (entity.getNm_filial() != null)
            repository.save(entity);
        return entity;
    }


}
