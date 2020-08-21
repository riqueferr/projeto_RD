package br.com.pi.projeto_RD.model.dto;

<<<<<<< HEAD
import io.swagger.models.auth.In;
=======
import br.com.pi.projeto_RD.model.entity.CategoriaEntity;
import br.com.pi.projeto_RD.model.entity.FornecedorEntity;
import br.com.pi.projeto_RD.model.entity.TipoProdutoEntity;
>>>>>>> 205187813d33a70577e33e76e50a6736075ec76b
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.io.Serializable;
=======
>>>>>>> 205187813d33a70577e33e76e50a6736075ec76b
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
<<<<<<< HEAD
public class ProdutoLoteDTO implements Serializable {

    private Integer idProdutoLote;
    private String dsLote;
    private Date dtFabricacao;
    private Date dtValidade;
    private Integer fkProduto;
    private Double vlLote;

=======
public class ProdutoLoteDTO {

    private Integer cd_lote;
    private String dsLote;
    private String dtFabricacao;
    private String dtValidade;

    private Integer idProduto;
    private String nm_fantasia;

    private Long id_status_produto;
    private String statusProduto;

    private double vl_unidade;

    private CategoriaEntity categoria;

    private TipoProdutoEntity tipoProduto;

//    private FornecedorEntity fornecedor;
>>>>>>> 205187813d33a70577e33e76e50a6736075ec76b

}
