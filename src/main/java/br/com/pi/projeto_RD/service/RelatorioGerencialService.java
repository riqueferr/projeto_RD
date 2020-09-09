package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.RelatorioGerencialDTO;
import br.com.pi.projeto_RD.repository.DocumentoFiscalRepository;
import br.com.pi.projeto_RD.service.bo.RelatorioGerencialBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class RelatorioGerencialService {

    @Autowired
    private RelatorioGerencialBO bo;

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private EntityManager manager;

    public List<RelatorioGerencialDTO>buscarVendasDiarias(Date dtEntrada, Long filial){

    }

}
