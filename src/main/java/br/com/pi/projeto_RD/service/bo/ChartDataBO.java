package br.com.pi.projeto_RD.service.bo;

import br.com.pi.projeto_RD.model.dto.ChartDataDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoFilialEstoqueEntity;
import br.com.pi.projeto_RD.repository.ProdutoFilialEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChartDataBO {

    @Autowired
    private ProdutoFilialEstoqueRepository repository;

    public ChartDataDTO parseToDTO(ProdutoFilialEstoqueEntity entity) {
        ChartDataDTO dto = new ChartDataDTO();

        if (entity == null)
            return dto;

//        dto.setData(entity.getQt_estoque());
        return dto;
    }
}
