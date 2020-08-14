package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.repository.TipoFornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FornecedorBO {

    @Autowired
    TipoFornecedorRepository tipoFornecedorRepository;
    public FornecedorDTO parseToDTO (FornecedorEntity f){
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
        dto.setFk_tipo_fornecedor(f.getFk_tipo_fornecedor());

        return dto;
    }

    public FornecedorEntity parseToEntity(FornecedorDTO dto, FornecedorEntity f){

        if (f == null)
            f = new FornecedorEntity();

        if (dto == null)
            return f;

        f.setCd_fornecedor(dto.getCd_fornecedor());
        f.setDs_denominacao(dto.getDs_denominacao());
        f.setNr_cnpj(dto.getNr_cnpj());
        f.setNm_razao_social(dto.getNm_razao_social());
        f.setNr_inscricao(dto.getNr_inscricao());
        f.setDs_email(dto.getDs_email());
        f.setNr_telefone(dto.getNr_telefone());
        f.setFk_tipo_fornecedor(tipoFornecedorRepository.getOne(dto.getFk_tipo_fornecedor().getId_tipo_fornecedor()));

        return f;


    }
}
