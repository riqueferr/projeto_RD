import { CupomDeVendaComponent } from './financeiro/cupom-de-venda/cupom-de-venda.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './abastecimento/dashboard/dashboard.component';
import { CadastroDeFornecedorComponent } from './abastecimento/cadastro-de-fornecedor/cadastro-de-fornecedor.component';
import { CadastroDeProdutoComponent } from './abastecimento/cadastro-de-produto/cadastro-de-produto.component';
import { EntradaDeProdutoComponent } from './abastecimento/entrada-de-produto/entrada-de-produto.component';
import { RelatorioDeEstoqueComponent } from './abastecimento/relatorio-de-estoque/relatorio-de-estoque.component';
import { RelatorioDeProdutoComponent } from './abastecimento/relatorio-de-produto/relatorio-de-produto.component';
import { TransferenciaDeProdutoComponent } from './abastecimento/transferencia-de-produto/transferencia-de-produto.component';
import { MovimentoDeLojaComponent } from './financeiro/movimento-de-loja/movimento-de-loja.component';
import { FinanceiroDashboardComponent } from './financeiro/financeiro-dashboard/financeiro-dashboard.component';
import { RelatorioGerencialComponent } from './financeiro/relatorio-gerencial/relatorio-gerencial.component';
import { ListaFornecedoresComponent } from './abastecimento/lista-fornecedores/lista-fornecedores.component';
import { DetalhamentoCupomDeVendasComponent } from './financeiro/detalhamento-cupom-de-vendas/detalhamento-cupom-de-vendas.component';
import { ListaProdutosComponent } from './abastecimento/lista-produtos/lista-produtos.component';
import { EditarProdutosComponent } from './abastecimento/lista-produtos/editar-produtos/editar-produtos.component';
import { EditarFornecedoresComponent } from './abastecimento/lista-fornecedores/editar-fornecedores/editar-fornecedores.component';
import { ListaEntradaComponent } from './abastecimento/lista-entrada/lista-entrada.component';


export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {path: 'abastecimento-dashboard',
    component: DashboardComponent},
    {path: 'cadastroDeFornecedor',
    component: CadastroDeFornecedorComponent},
    {path: 'cadastroDeProduto',
    component: CadastroDeProdutoComponent},
    {path: 'entradaDeProduto',
    component: EntradaDeProdutoComponent},
    {path: 'relatorioDeEstoque',
    component: RelatorioDeEstoqueComponent},
    {path: 'relatorioDeProduto',
    component: RelatorioDeProdutoComponent},
    {path: 'transferenciaDeProduto',
    component: TransferenciaDeProdutoComponent},
    {path: 'cupomDeVenda',
    component: CupomDeVendaComponent},
    {path: 'financeiro-dashboard',
    component: FinanceiroDashboardComponent},
    {path: 'movimentoDeLoja',
    component: MovimentoDeLojaComponent},
    {path: 'relatorioGerencial',
    component: RelatorioGerencialComponent},
    {path: 'listaFornecedores',
    component: ListaFornecedoresComponent},
    {path: 'listaEntradaProdutos',
    component: ListaEntradaComponent},
    {path: 'listaProdutos',
    component: ListaProdutosComponent},
    {path: 'listaProdutos/:nm_fantasia',
    component: ListaProdutosComponent},
    {path: 'detalhamentoCupomDeVendas/:idDF',
    component: DetalhamentoCupomDeVendasComponent},
    {path: 'produtos/editar/:codigo',
    component: EditarProdutosComponent},
    {path: 'fornecedores/editar/:cd_fornecedor',
    component: EditarFornecedoresComponent},
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }
