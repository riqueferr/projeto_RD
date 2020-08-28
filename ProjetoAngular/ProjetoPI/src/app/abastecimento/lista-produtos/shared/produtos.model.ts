export interface Produtos {
    nm_fantasia: String,
    statusProduto: {
        idStatusProduto: number
    },
    subCategoria: {
        idSubCategoria: number,
    },
    tipo_produto: {
        idTipoProduto: number,
    },
    nm_fabricante: String,
    vl_unidade: number,
    fornecedor: [
        {
            cd_fornecedor: number
        }
    ]
}

export interface ResponseProdutos {
    produtos: Produtos[];
}