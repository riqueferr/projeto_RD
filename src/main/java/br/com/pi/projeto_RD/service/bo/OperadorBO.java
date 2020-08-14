package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.dto.OperadorDTO;
import br.com.pi.projeto_RD.model.dto.PerfilDTO;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import br.com.pi.projeto_RD.repository.OperadorRepository;
import br.com.pi.projeto_RD.repository.TipoFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
        dto.setNm_operador(o.getNm_operador());
        dto.setNr_cpf(o.getNr_cpf());
        dto.setNr_matricula(o.getNr_matricula());
        dto.setDs_cargo(o.getDs_cargo());
        dto.setCd_filial(o.getCd_filial());
        dto.setPw_operador(o.getPw_operador());

        List<PerfilDTO> perfil = new ArrayList<>();

        for (PerfilEntity item : o.getPerfil()) {
            PerfilDTO pfDTO = new PerfilDTO();
            pfDTO.setId(item.getId());
            pfDTO.setDs_perfil(item.getDs_perfil());

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
        o.setNm_operador(dto.getNm_operador());
        o.setNr_cpf(dto.getNr_cpf());
        o.setNr_matricula(dto.getNr_matricula());
        o.setDs_cargo(dto.getDs_cargo());
        o.setCd_filial(dto.getCd_filial());
        o.setPw_operador(dto.getPw_operador());

        List<PerfilEntity> itemsEntity = new ArrayList<>();

        for (PerfilDTO itemDTO : dto.getPerfil()) {
            PerfilEntity pEntity = new PerfilEntity();
            pEntity.setId(itemDTO.getId());
            pEntity.setDs_perfil(itemDTO.getDs_perfil());

            itemsEntity.add(pEntity);
        }

        o.setPerfil(itemsEntity);

        return o;


    }

}
