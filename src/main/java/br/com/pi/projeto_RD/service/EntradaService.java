package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.EntradaDTO;
import br.com.pi.projeto_RD.model.entity.EntradaEntity;
import br.com.pi.projeto_RD.repository.EntradaRepository;
import br.com.pi.projeto_RD.service.bo.EntradaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaBO entradaBO;

    @Autowired
    private EntradaRepository entradaRepository;

    public List<EntradaDTO> buscarTodos(){
        List<EntradaEntity> entradaEntity = entradaRepository.findAll();
        List<EntradaDTO> entradaDTO = new ArrayList<>();

        for (EntradaEntity e : entradaEntity){
            EntradaDTO dto = entradaBO.parseToDTO(e);
            entradaDTO.add(dto);
        }
        return entradaDTO;
    }



    public EntradaDTO buscarPorId(Integer codigo){
        return entradaBO.parseToDTO(entradaRepository.getOne(codigo));
    }
}
