package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.FornecedorDTO;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.repository.FornecedorRepository;
import br.com.pi.projeto_RD.repository.TipoFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FornecedorService {


    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private TipoFornecedorRepository tipoFornecedorRepository;

    public List<FornecedorDTO> buscarTodos(){
        List<FornecedorEntity> fornecedorEntity = repository.findAll();
        List<FornecedorDTO> fornecedorDTO = new ArrayList<>();

          // TODO: 12/08/2020
//        for (FornecedorEntity entity : fornecedorEntity){
//            FornecedorDTO dto
//        }
    }




}
