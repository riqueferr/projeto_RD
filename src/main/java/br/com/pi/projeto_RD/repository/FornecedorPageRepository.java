package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FornecedorPageRepository extends PagingAndSortingRepository<FornecedorEntity, Long> {

}
