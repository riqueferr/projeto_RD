package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.EntradaDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.entity.EntradaEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
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
    private EntradaRepository repository;

    public List<EntradaDTO> buscarTodos(){
        List<EntradaEntity> entradaEntity = repository.findAll();
        List<EntradaDTO> entradaDTO = new ArrayList<>();

        for (EntradaEntity e : entradaEntity){
            EntradaDTO dto = entradaBO.parseToDTO(e);
            entradaDTO.add(dto);
        }
        return entradaDTO;
    }



    public EntradaDTO buscarPorId(Integer codigo){
        return entradaBO.parseToDTO(repository.getOne(codigo));
    }



//    public void inserir(EntradaDTO dto) {
//        EntradaEntity entity = entradaBO.parseToEntity(dto, null);
//        if(entity.getId_entrada() != null){
//            entradaRepository.save(entity);
//        }
//    }


    public EntradaDTO excluirPorId(Integer id_entrada) {
        EntradaEntity entity = repository.getOne(id_entrada);
        EntradaDTO dto = new EntradaDTO();

        if (entity != null) {
            dto = entradaBO.parseToDTO(entity);
            repository.delete(entity);
        }
        return dto;
    }
}
