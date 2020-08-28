export interface Produtos {
    nm_fantasia: String,
    statusProduto: {
        idStatusProduto: number
    },
    categoria: {
        idCategoria: number,
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