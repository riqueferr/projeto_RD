
export interface Nota {
    idDF: number;
    dt_entrada: String;
    nmFilial: String;
    idFilial: number;
    cliente: Cliente;
    operacao: Operacao;
    item: Itens;
    vl_documento_fiscal: number;
}


export interface Operacao {
    cdOperacao: number;
    dsOperacao: String;
}

export interface Cliente{
    idCliente: number;
    nmCliente: String;
}

export interface Itens{
    cdProduto: number;
    nmProduto: String;
    qtItem: number;
    pcIcms: number;
    vlIcms: number;
}

export interface ResponseDF {
    notas: Nota[];
    itens: Itens[];
}