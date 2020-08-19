package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.EntradaDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.EntradaEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.repository.EntradaRepository;
import br.com.pi.projeto_RD.repository.FilialRepository;
import br.com.pi.projeto_RD.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EntradaBO {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
     private DocumentoFiscalRepository documentoFiscalRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public EntradaDTO parseToDTO(EntradaEntity e){
        EntradaDTO dto = new EntradaDTO();

        if(e==null)
            return dto;

        dto.setId_entrada(e.getId_entrada());
        dto.setNm_produto(e.getNm_produto());
        dto.setDt_entrada(e.getDt_entrada());
        dto.setFornecedor(e.getFornecedor());
        dto.setFilial(e.getFilial());
        dto.setDocumento(e.getDocumento_fiscal());

        return dto;
    }

    public EntradaEntity parseToEntity(EntradaDTO dto, EntradaEntity entradaEntity){
        if (entradaEntity == null)
            return entradaEntity = new EntradaEntity();

        if (dto==null)
            return entradaEntity;

        entradaEntity.setId_entrada(dto.getId_entrada());
        entradaEntity.setNm_produto(dto.getNm_produto());
        entradaEntity.setDt_entrada(dto.getDt_entrada());
        entradaEntity.setFornecedor(fornecedorRepository.getOne(dto.getFornecedor().getCd_fornecedor()));
        entradaEntity.setFilial(filialRepository.getOne(dto.getFilial().getCd_filial()));
        entradaEntity.setDocumento_fiscal(documentoFiscalRepository.getOne(dto.getDocumento().getId_documento()));

        return entradaEntity;


    }

}
