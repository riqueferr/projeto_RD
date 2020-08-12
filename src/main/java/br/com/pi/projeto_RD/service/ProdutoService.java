package br.com.pi.projeto_RD.service;



import br.com.pi.projeto_RD.model.dto.ProdutoDto;
import br.com.pi.projeto_RD.model.dto.StatusProdutoDTO;
import br.com.pi.projeto_RD.model.entity.ProdutoEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.repository.CategoriaRepository;
import br.com.pi.projeto_RD.repository.ProdutoRepository;
import br.com.pi.projeto_RD.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoBO produtoBO;

//    public List<ProdutoDto> buscarTodas() {

//        List<ProdutoDto> listDTO = new ArrayList<>();
//        for (ProdutoEntity entity : repository.findAll()) {
//            ProdutoDto dto = produtoBO.parseToDTO(entity);
//            listDTO.add(dto);
//        }
//        return listDTO;
//    }

    public List<ProdutoDto> listarTodas() {


        List<ProdutoDto> listaDTO = new ArrayList<>();
        List<ProdutoEntity> listaEntity = repository.findAll();
        for (ProdutoEntity p : listaEntity) {
            ProdutoDto dto = new ProdutoDto();
            dto.setCodigo(p.getCodigo());
            dto.setNm_fantasia(p.getNm_fantasia());
            dto.setStatusProduto(p.getStatus().getDsStatusProduto());
            dto.setCategoria(p.getCategoria().getDsCategoria());
            dto.setSub_categoria(p.getCategoria().getSubCategoria().getDsSubCategoria());
            dto.setTipo_produto(p.getTipo_produto().getDsTipoProduto());
            dto.setNm_fabricante(p.getNm_fabricante());
            dto.setVl_unidade(p.getVl_unidade());
            dto.setDs_altura(p.getDs_altura());
            dto.setDs_peso(p.getDs_peso());
            dto.setDs_largura(p.getDs_largura());
            dto.setId_imagem(p.getId_imagem());

            listaDTO.add(dto);
        }

        return listaDTO;
    }

    public ProdutoDto buscarPorId(Integer codigo){
        return produtoBO.parseToDTO(repository.getOne(codigo));
    }

    public ProdutoEntity inserir(ProdutoDto dto) {
        ProdutoEntity pEntity = new ProdutoEntity();

        pEntity.setCodigo(dto.getCodigo());
        pEntity.setNm_fantasia(dto.getNm_fantasia());

        pEntity.setNm_fabricante(dto.getNm_fabricante());
        pEntity.setVl_unidade(dto.getVl_unidade());
        pEntity.setDs_altura(dto.getDs_altura());
        pEntity.setDs_peso(dto.getDs_peso());
        pEntity.setDs_largura(dto.getDs_largura());
        pEntity.setId_imagem(dto.getId_imagem());

        return repository.save(pEntity);

    }

//    public void inserir(ProdutoDto dto) {
//        ProdutoEntity entity = produtoBO.parseToEntity(dto, null);
//        if(entity.getNm_fantasia() != null)
//            repository.save(entity);
//    }

    public void atualizar(ProdutoDto dto) {

        ProdutoEntity entity = repository.getOne(dto.getCodigo());
        if(entity != null){
            entity = produtoBO.parseToEntity(dto, entity);
            repository.save(entity);
        }
    }

    public ProdutoDto excluirPorId(Integer codigo){
        ProdutoEntity entity = repository.getOne(codigo);
        ProdutoDto dto = new ProdutoDto();

        if(entity != null) {
            dto = produtoBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }

//    public List<ProdutoEntity> buscarPorNome(String nome){
//        return repository.findByNome(nome);
//    }

}
