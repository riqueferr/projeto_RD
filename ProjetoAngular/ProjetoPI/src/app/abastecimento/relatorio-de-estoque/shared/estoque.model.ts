export interface Produtos {
    cdFilial: number;
    nmFilial: String;
    codProduto: number;
    // produto: Produtos;
}

// export interface Produtos {
//     cdProduto: number;
//     nmProduto: String;
//     categoria: String;
//     tipoProduto: String;
//     quantidade: number;
// }

export interface ResponseEstoque {
    produtos: Produtos[];
}