package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.OperadorDTO;
import br.com.pi.projeto_RD.model.dto.PerfilDTO;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import br.com.pi.projeto_RD.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperadorBO {

    @Autowired
    OperadorRepository operadorRepository;

    public OperadorDTO parseToDTO(OperadorEntity o) {
        OperadorDTO dto = new OperadorDTO();

        if (o == null)
            return dto;

        dto.setIdOperador(o.getIdOperador());
        dto.setNmOperador(o.getNmOperador());
        dto.setNrCpf(o.getNrCpf());
        dto.setNrMatricula(o.getNrMatricula());
        dto.setDsCargo(o.getDsCargo());
        dto.setCdFilial(o.getCdFilial());
        dto.setPwOperador(o.getPwOperador());

        List<PerfilDTO> perfil = new ArrayList<>();

        for (PerfilEntity item : o.getPerfil()) {
            PerfilDTO pfDTO = new PerfilDTO();
            pfDTO.setId(item.getId());
            pfDTO.setDsPerfil(item.getDsPerfil());

            perfil.add(pfDTO);
        }

        dto.setPerfil(perfil);

        return dto;
    }

    public OperadorEntity parseToEntity(OperadorDTO dto, OperadorEntity o) {

        if (o == null)
            o = new OperadorEntity();

        if (dto == null)
            return o;

        o.setIdOperador(dto.getIdOperador());
        o.setNmOperador(dto.getNmOperador());
        o.setNrCpf(dto.getNrCpf());
        o.setNrMatricula(dto.getNrMatricula());
        o.setDsCargo(dto.getDsCargo());
        o.setCdFilial(dto.getCdFilial());
        o.setPwOperador(dto.getPwOperador());

        List<PerfilEntity> itemsEntity = new ArrayList<>();

        for (PerfilDTO itemDTO : dto.getPerfil()) {
            PerfilEntity pEntity = new PerfilEntity();
            pEntity.setId(itemDTO.getId());
            pEntity.setDsPerfil(itemDTO.getDsPerfil());

            itemsEntity.add(pEntity);
        }

        o.setPerfil(itemsEntity);

        return o;


    }

}
