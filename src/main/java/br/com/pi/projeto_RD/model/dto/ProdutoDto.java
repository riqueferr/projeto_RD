package br.com.pi.projeto_RD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Integer codigo;
    private Integer status_produto;
    private Integer categoria;
    private Integer tipo_produto;
    private String nm_fantasia;
    private String nm_fabricante;
    private double vl_unidade;
    private String ds_altura;
    private String ds_peso;
    private String ds_largura;
    private Integer id_imagem;

}
