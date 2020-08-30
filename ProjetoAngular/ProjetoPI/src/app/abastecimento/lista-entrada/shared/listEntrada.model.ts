export interface Produtos {
    idDocumento: number,
    nmFornecedor: String,
    dtEntrada: string,
    vlDocumentoFiscal: String
    itens: [
        {
            cdProduto: number,
            nmProduto: String,
            qtItem: number,
        }
    ]
}

export interface ResponseProdutos {
    produtos: Produtos[];
}