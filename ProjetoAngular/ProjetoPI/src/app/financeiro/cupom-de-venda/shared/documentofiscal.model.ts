
export interface Nota {
    idDF: number;
    cliente: String;
    operacao: String;
    fornecedor: String;
    dt_entrada: String;
    nmFilial: String;
    idFilial: number;
    item: Itens;
    vl_documento_fiscal: number;
}

export interface Itens{
    cdProduto: number;
    nmProduto: String;
    qtItem: number;
    pcIcms: number;
    vlIcms: number;
}

export interface Pagamentos{
    idTipoPagamento: number;
    dsTipoPagamento: String;
    vlPagamento: number;
}

export interface ResponseDF {
    notas: Nota[];
    itens: Itens[];
    pagamento: Pagamentos[];
}