package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.EntradaDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoFilialDTO;
import br.com.pi.projeto_RD.model.dto.ProdutoLoteDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.EntradaEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoLoteEntity;
import br.com.pi.projeto_RD.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ProdutoFilialEstoqueRepository produtoFilialEstoqueRepository;

    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public EntradaDTO parseToDTO(EntradaEntity e){
        EntradaDTO dto = new EntradaDTO();

        if(e == null)
            return dto;


        dto.setId_entrada(e.getId_entrada());
        dto.setDt_entrada(date.format(e.getDt_entrada()));
        dto.setNm_filial(e.getFilial().getNm_filial());
        //dto.setId_filial(e.getFilial().getCd_filial());
        dto.setId_documento_fiscal(e.getDocumento_fiscal().getId_documento());

        List<ProdutoLoteDTO> produto = new ArrayList<>();

        for (ProdutoLoteEntity item : e.getProdutoLote()) {
            ProdutoLoteDTO eDTO = new ProdutoLoteDTO();

            eDTO.setCd_lote(item.getId_produto_lote());
            eDTO.setNm_fantasia(item.getProduto().getNm_fantasia());
            eDTO.setId_status_produto(item.getProduto().getStatus().getIdStatusProduto());
            eDTO.setStatusProduto(item.getProduto().getStatus().getDsStatusProduto());
            eDTO.setVl_unidade(item.getProduto().getVl_unidade());
            eDTO.setCategoria(item.getProduto().getCategoria());
            eDTO.setTipoProduto(item.getProduto().getTipo_produto());


            produto.add(eDTO);
        }
        dto.setProduto(produto);
        return dto;
    }


    public EntradaEntity parseToEntity(EntradaDTO dto, EntradaEntity entradaEntity){
        if (entradaEntity == null)
            return entradaEntity = new EntradaEntity();

        if (dto == null)
            return entradaEntity;

        entradaEntity.setId_entrada(dto.getId_entrada());
        //entradaEntity.setDt_entrada(date.format(dto.getDt_entrada()));
//        entradaEntity.setFornecedor(fornecedorRepository.getOne(dto.getFornecedor().getCd_fornecedor()));
//        entradaEntity.setFilial(filialRepository.getOne(dto.getFilial().getCd_filial()));
//        entradaEntity.setDocumento_fiscal(documentoFiscalRepository.getOne(dto.getDocumento().getId_documento()));



        return entradaEntity;


    }

}
