export interface Entradas {
    operacao: {
        cdOperacao: number
    },
    idFilial: number,
    idFornecedor: number,
    chaveAcesso: number,
    nrNF: number,
    nrSerie: number,
    dtEmissao: Date,
    dtEntrada: Date,
    // dtAbertura: Date,
    // dtFechamento: Date,
    vlDocumentoFiscal: number,
    itens: [
        {
            nrItemDocumento: number,
            cdProduto: number,
            qtItem: number,
            pcIcms: number,
            vlIcms: number
        }
    ]
}


export interface ResponseEntradas {
  entradas: Entradas[];
}


