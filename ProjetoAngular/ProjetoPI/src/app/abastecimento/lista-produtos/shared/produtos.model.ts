export interface Produtos {
    nm_fantasia: String,
    statusProduto: {
        idStatusProduto: number
    },
    subCategoria: {
        idSubCategoria: number,
        dsSubCategoria: String
    },
    tipo_produto: {
        idTipoProduto: number,
    },
    nm_fabricante: String,
    vl_unidade: number,
    dsProduto: String,
    fornecedor: [
        {
            cd_fornecedor: number
        }
    ]
}

export interface SubCategorias {
    idSubCategoria: number,
    dsSubCategoria: String
}

export interface ResponseSubCategorias{
    subCategorias: SubCategorias[];
}

export interface Status{
    idStatusProduto: number,
    dsStatusProduto: String
}

export interface ResponseStatus{
    status: Status[];
}

export interface TipoProduto{
    idTipoProduto: number,
    dsTipoProduto: String
}

export interface ResponseTipoProduto{
    tipoProduto: TipoProduto[];
}

export interface ResponseProdutos {
    produtos: Produtos[];
}