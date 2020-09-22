export interface Produtos {
    cdFilial: number;
    nmFilial: String;
    cdProduto: number;
    qt_estoque: number;
}

export interface ResponseEstoque {
    produtos: Produtos[];
}