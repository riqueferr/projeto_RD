export interface Transferencia {
    operacao: {
        cdOperacao: number
    },
    idFilial: number,
    idFilialDestino: number,
    chaveAcesso: number,
    nrNF: number,
    nrSerie: number,
    emissao: Date,
    entrada: Date,
    vlDocumentoFiscal: number,
    itens: ResponseEntradaItens []
}

export class ResponseTransferencia {
    transferencia: Transferencia[];
}

export class ResponseEntradaItens{
    // constructor(
    //     public nrItemDocumento: number,
    //     public cdProduto: number,
    //     public qtItem: number,
    //     public nmProduto: String
    //       ){}
    nrItemDocumento: number;
    cdProduto: number;
    qtItem: number;
    nmProduto: String;
}

export interface ResponseFiliais {
    filiais: Filiais[];
}

export interface Filiais {
    cd_filial: number,
    nm_filial: String,
}

export interface Produto {
    codigo: number,
    nm_fantasia: String
}


