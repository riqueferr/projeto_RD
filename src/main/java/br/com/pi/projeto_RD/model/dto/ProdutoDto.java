package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.StatusProdutoEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Integer codigo;
    private String nm_fantasia;
    private StatusProdutoEntity statusProduto;
    private CategoriaEntity categoria;
    private TipoProdutoEntity tipo_produto;
    private String nm_fabricante;
    private double vl_unidade;
    private String ds_altura;
    private String ds_peso;
    private String ds_largura;
    private Integer id_imagem;

    private List<FornecedorProdutoDTO> fornecedor;

}
