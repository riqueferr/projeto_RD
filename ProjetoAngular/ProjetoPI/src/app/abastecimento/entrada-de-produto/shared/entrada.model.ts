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
    itens: ResponseEntradaItens[]
}

export class ResponseEntradas {
    entradas: Entradas[];
}

export class ResponseEntradaItens {
    // constructor(
    //     public nrItemDocumento: number,
    //     public cdProduto: number,
    //     public qtItem: number,
    //     public nmProduto: String
    // ){}
    nrItemDocumento: number;
    cdProduto: number;
    qtItem: number;
    nmProduto: String;
}

export interface Produto {
    codigo: number,
    nm_fantasia: String
}

