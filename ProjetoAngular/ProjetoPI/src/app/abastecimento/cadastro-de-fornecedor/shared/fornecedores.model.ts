export interface Fornecedores {
  cd_fornecedor: number;
  nr_cnpj: string;
  nm_razao_social: string;
  ds_denominacao: string;
  nr_inscricao: string;
  ds_email: string;
  nr_telefone: string;
  nr_celular: string;
  fk_tipo_fornecedor: {
    id_tipo_fornecedor: number;
    ds_tipo_fornecedor: string;
  },
  endereco: [
    {
      dsEndereco: string;
      nrEndereco: string;
      nrCep: string;
      dsBairro: string;
      dsCidade: string;
      sgEstado: string;
      nmComplemento: string;
    }
  ]
}

export interface ResponseFornecedores {
  fornecedores: Fornecedores[];
}


