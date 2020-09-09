package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.RelatorioGerencialDTO;
import br.com.pi.projeto_RD.model.entity.DocumentoFiscalEntity;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RelatorioGerencialBO {


    @Autowired
    private DocumentoFiscalRepository repository;

    public RelatorioGerencialDTO parseToDTO (DocumentoFiscalEntity d) {
        RelatorioGerencialDTO dto = new RelatorioGerencialDTO();
         if (d == null)
             return dto;
         dto.setDtEntrada(d.getDtEntrada());
         dto.setIdDocumento(d.getIdDocumento());
         dto.setOperacao(d.getOperacao());
         dto.setVlDocumento(d.getVlDocumentoFiscal());
          return dto;
         //dto.setPagamento(d.getPagamento());
        //dto.setProduto();
    }
}
