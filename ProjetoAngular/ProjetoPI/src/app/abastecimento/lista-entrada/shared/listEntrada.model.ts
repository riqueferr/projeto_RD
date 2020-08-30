export interface Entradas {
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

export interface ResponseEntrada {
    entradas: Entradas[];
}