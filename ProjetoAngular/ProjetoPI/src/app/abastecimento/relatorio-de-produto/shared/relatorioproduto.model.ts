
export interface Produto {
    cdProduto: number;
    nmProduto: String;
    tipoProduto: String;
    statusProduto: String;
    fornecedor: Fornecedores;
}

export interface Fornecedores {
    nm_razao_social: String;
}

export interface ResponseRelatorioProduto {
    produtos: Produto[];
}