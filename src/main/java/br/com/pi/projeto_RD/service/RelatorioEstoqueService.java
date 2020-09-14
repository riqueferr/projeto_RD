package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.FilialDTO;
import br.com.pi.projeto_RD.model.dto.RelatorioEstoqueDTO;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.service.bo.RelatorioEstoqueBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioEstoqueService {

    @Autowired
    private RelatorioEstoqueBO bo;

    @Autowired
    private FilialRepository repository;

    public List<RelatorioEstoqueDTO> buscarTodos() {
        List<FilialEntity> filialEntity = repository.findAll();
        List<RelatorioEstoqueDTO> relatorioEstoqueDTO = new ArrayList<>();


        for (FilialEntity entity : filialEntity) {
            RelatorioEstoqueDTO dto = bo.parseToDTO(entity);
            relatorioEstoqueDTO.add(dto);
        }
        return relatorioEstoqueDTO;
    }

    public RelatorioEstoqueDTO buscarPorId(BigInteger codigo) {
        return bo.parseToDTO(repository.getOne(codigo));
    }

}
