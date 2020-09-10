export interface Transferencia {
    operacao: {
        cdOperacao: number
    },
    idFilial: number,
    idFilialDestino: number,
    chaveAcesso: number,
    nrNF: number,
    nrSerie: number,
    dtEmissao: Date,
    dtEntrada: Date,
    itens: [
        {
            nrItemDocumento: number,
            cdProduto: number,
            qtItem: number,
        }
    ]
}

export class ResponseTransferencia {
    transferencia: Transferencia[];
}


