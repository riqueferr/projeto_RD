package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.OperadorDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.repository.OperadorRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.OperadorBO;
import br.com.pi.projeto_RD.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperadorService {

    @Autowired
    private OperadorRepository repository;


    @Autowired
    private OperadorBO operadorBO;

    public List<OperadorDTO> listarTodas() {
        List<OperadorEntity> listEntity = repository.findAll();
        List<OperadorDTO> listDTO = new ArrayList<>();

        for (OperadorEntity entity : repository.findAll()) {
            OperadorDTO dto = operadorBO.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public OperadorDTO buscarPorId(Long codigo) {
        return operadorBO.parseToDTO(repository.getOne(codigo));
    }

}
