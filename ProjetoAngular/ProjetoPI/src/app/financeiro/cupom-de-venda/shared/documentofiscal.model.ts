
export interface Nota {
    idDF: number;
    dt_entrada: String;
    nmFilial: String;
    cliente: Cliente;
    operacao: Operacao;
    vl_documento_fiscal: number;
}


export interface Operacao {
    cdOperacao: number;
    dsOperacao: String;
}

export interface Cliente{
    idCliente: number;
}

export interface ResponseDF {
    notas: Nota[];
}