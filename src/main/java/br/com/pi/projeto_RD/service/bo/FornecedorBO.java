package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.EnderecoDTO;
import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.dto.PerfilDTO;
import br.com.pi.projeto_RD.model.entity.EnderecoEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.PerfilEntity;
import br.com.pi.projeto_RD.repository.TipoFornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FornecedorBO {

    @Autowired
    TipoFornecedorRepository tipoFornecedorRepository;

    public FornecedorDTO parseToDTO(FornecedorEntity f) {
        FornecedorDTO dto = new FornecedorDTO();

        if (f == null)
            return dto;

        dto.setCd_fornecedor(f.getCd_fornecedor());
        dto.setDs_denominacao(f.getDs_denominacao());
        dto.setNr_cnpj(f.getNr_cnpj());
        dto.setNm_razao_social(f.getNm_razao_social());
        dto.setNr_inscricao(f.getNr_inscricao());
        dto.setDs_email(f.getDs_email());
        dto.setNr_telefone(f.getNr_telefone());
        dto.setNr_celular(f.getNr_celular());
        dto.setFk_tipo_fornecedor(f.getFk_tipo_fornecedor());

        List<EnderecoDTO> endereco = new ArrayList<>();

        for (EnderecoEntity item : f.getEndereco()) {
            EnderecoDTO eDTO = new EnderecoDTO();
            eDTO.setIdEndereco(item.getIdEndereco());
            eDTO.setDsEndereco(item.getDsEndereco());
            eDTO.setNrEndereco(item.getNrEndereco());
            eDTO.setNrCep(item.getNrCep());
            eDTO.setDsBairro(item.getDsBairro());
            eDTO.setDsCidade(item.getDsCidade());
            eDTO.setSgEstado(item.getSgEstado());
            eDTO.setNmComplemento(item.getNmComplemento());

            endereco.add(eDTO);
        }

        dto.setEndereco(endereco);

        return dto;
    }

    public FornecedorEntity parseToEntity(FornecedorDTO dto, FornecedorEntity f) {

        if (f == null)
            f = new FornecedorEntity();

        if (dto == null)
            return f;

//        f.setCd_fornecedor(dto.getCd_fornecedor());
        f.setDs_denominacao(dto.getDs_denominacao());
        f.setNr_cnpj(dto.getNr_cnpj());
        f.setNm_razao_social(dto.getNm_razao_social());
        f.setNr_inscricao(dto.getNr_inscricao());
        f.setDs_email(dto.getDs_email());
        f.setNr_telefone(dto.getNr_telefone());
        f.setNr_celular(dto.getNr_celular());
        f.setFk_tipo_fornecedor(tipoFornecedorRepository.getOne(dto.getFk_tipo_fornecedor().getId_tipo_fornecedor()));

        List<EnderecoEntity> itemsEndereco = new ArrayList<>();

        for (EnderecoDTO itemDTO : dto.getEndereco()) {
            EnderecoEntity fEntity = new EnderecoEntity();

//                fEntity.setIdEndereco(itemDTO.getIdEndereco());
            fEntity.setDsEndereco(itemDTO.getDsEndereco());
            fEntity.setNrEndereco(itemDTO.getNrEndereco());
            fEntity.setNrCep(itemDTO.getNrCep());
            fEntity.setDsBairro(itemDTO.getDsBairro());
            fEntity.setDsCidade(itemDTO.getDsCidade());
            fEntity.setSgEstado(itemDTO.getSgEstado());
            fEntity.setNmComplemento(itemDTO.getNmComplemento());

            itemsEndereco.add(fEntity);
        }

        f.setEndereco(itemsEndereco);

        return f;


    }
}
