export interface Filial {
    cd_filial: number;
    nm_filial: String;
    produto: Produtos;
}

export interface Produtos {
    cdProduto: number;
    nmProduto: String;
    categoria: String;
    tipoProduto: String;
    quantidade: number;
}

export interface ResponseEstoque {
    produtos: Produtos[];
}