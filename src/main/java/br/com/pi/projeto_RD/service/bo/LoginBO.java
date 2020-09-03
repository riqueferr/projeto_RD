package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.OperadorDTO;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class LoginBO {

    public OperadorDTO parseToDTO(OperadorEntity entity) {
        OperadorDTO dto = new OperadorDTO();

        if (entity == null)
            return dto;

        dto.setIdOperador(entity.getIdOperador());
        dto.setNmOperador(entity.getNmOperador());
        dto.setNrCpf(entity.getNrCpf());
        dto.setNrMatricula(entity.getNrMatricula());
        dto.setDsCargo(entity.getDsCargo());
        dto.setCdFilial(entity.getCdFilial());
        dto.setPwOperador(entity.getPwOperador());

        return dto;
    }

    public OperadorEntity parseToEntity(OperadorDTO dto, OperadorEntity entity) {


        if (entity == null)
            entity = new OperadorEntity();

        if (dto == null)
            return entity;

        entity.setIdOperador(dto.getIdOperador());
        entity.setNmOperador(dto.getNmOperador());
        entity.setNrCpf(dto.getNrCpf());
        entity.setNrMatricula(dto.getNrMatricula());
        entity.setDsCargo(dto.getDsCargo());
        entity.setCdFilial(dto.getCdFilial());

        String codificado = Base64.getEncoder().encodeToString(dto.getPwOperador().getBytes());
        entity.setPwOperador(codificado);

        return entity;
    }
}