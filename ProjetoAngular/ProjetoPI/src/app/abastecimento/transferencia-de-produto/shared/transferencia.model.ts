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
    itens: ResponseEntradaItens []
}

export class ResponseTransferencia {
    transferencia: Transferencia[];
}

export class ResponseEntradaItens{
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


