export interface Entradas {
    operacao: {
        cdOperacao: number
    },
    idFilial: number,
    idFornecedor: number,
    chaveAcesso: number,
    nrNF: number,
    nrSerie: number,
    emissao: String,
    entrada: Date,
    vlDocumentoFiscal: number,
    itens: ResponseEntradaItens []
}


export class ResponseEntradas {
  entradas: Entradas[];
}

export class ResponseEntradaItens{
    nrItemDocumento: number;
    cdProduto: number;
    qtItem: number;
    nmProduto: String;
}

