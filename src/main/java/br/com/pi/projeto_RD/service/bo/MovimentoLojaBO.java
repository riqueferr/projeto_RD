package br.com.pi.projeto_RD.service.bo;


import br.com.pi.projeto_RD.model.dto.MovimentoLojaDTO;
import br.com.pi.projeto_RD.model.dto.PagamentoDocDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.model.entity.FilialEntity;
import br.com.pi.projeto_RD.model.entity.PagamentoDocEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovimentoLojaBO {

    @Autowired
    private DocumentoFiscalRepository repository;



    public MovimentoLojaDTO parseToDTO(DocumentoFiscalEntity d) {
        MovimentoLojaDTO dto = new MovimentoLojaDTO();

        if (d == null)
            return dto;
        dto.setIdDocumento(d.getIdDocumento());
//        dto.setFilial(d.getFilial().getCdFilial());
        dto.setDtEntrada(d.getDtEntrada());

//        List<PagamentoDocDTO> pg = new ArrayList<>();
//        for (PagamentoDocEntity item : d.getPagamento()) {
//            PagamentoDocDTO eDTO = new PagamentoDocDTO();
//
//            eDTO.setIdTipoPagamento(item.getTipoPagamento().getIdTipoPagamento());
//            eDTO.setDsTipoPagamento(item.getTipoPagamento().getDsTipoPagamento());
//            eDTO.setVlPagamento(item.getVlPagamento());
//
//            pg.add(eDTO);
//        }
//        dto.setPagamento(pg);

        return dto;

    }

}
