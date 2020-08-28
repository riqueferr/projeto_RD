export interface Produtos {
    codigo: number;
    nm_fantasia: String;
    status: Status;
    fornecedor: Fornecedores;
    categoria: Categoria;
    tipoProduto: TipoProduto;
    nm_fabricante: String;
    vl_unidade: number;
    ds_altura: number;
    ds_peso: number;
    ds_largura: number;
}

export interface Fornecedores {
    cd_fornecedor: number;
    nm_razao_social: String;
}

export interface Status{
    idStatusProduto: number;
}

export interface Categoria{
    idStatusProduto: number;
}

export interface TipoProduto{
    idTipoProduto: number;
}

export interface ResponseProdutos {
    produtos: Produtos[];
}