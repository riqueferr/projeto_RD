export interface Produtos {
    codigo: number;
    nm_fantasia: String;
    fornecedor: Fornecedores;
}

export interface Fornecedores {
    nm_razao_social: String;
}

export interface ResponseProdutos {
    produtos: Produtos[];
}