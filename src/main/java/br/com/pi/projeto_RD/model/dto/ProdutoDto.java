package br.com.pi.projeto_RD.model.dto;

import br.com.pi.projeto_RD.model.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private BigInteger codigo;
    private String nm_fantasia;

    private StatusProdutoEntity statusProduto;
    private SubCategoriaEntity subCategoria;
    private TipoProdutoEntity tipo_produto;

    private String nm_fabricante;
    private BigDecimal vl_unidade;
    private String ds_altura;
    private String ds_peso;
    private String ds_largura;
//    private Integer id_imagem;
    private String dsProduto;

    private List<FornecedorProdutoDTO> fornecedor;

}
