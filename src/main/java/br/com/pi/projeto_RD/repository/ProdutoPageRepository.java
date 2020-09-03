package br.com.pi.projeto_RD.repository;

import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProdutoPageRepository  extends PagingAndSortingRepository<ProdutoEntity, Integer> {


}
