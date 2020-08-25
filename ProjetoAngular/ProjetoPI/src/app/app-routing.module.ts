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
    component: ListaFornecedoresComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }
