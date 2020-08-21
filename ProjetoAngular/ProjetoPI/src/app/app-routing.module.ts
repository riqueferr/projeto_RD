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

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {path:'abastecimento-dashboard',
    component: DashboardComponent},
    {path: 'cadastroDeFornecedor', 
    component: CadastroDeFornecedorComponent},
    {path:'cadastroDeProduto',
    component: CadastroDeProdutoComponent},
    {path:'entradaDeProduto',
    component: EntradaDeProdutoComponent},
    {path:'relatorioDeEstoque',
    component: RelatorioDeEstoqueComponent},
    {path:'relatorioDeProduto',
    component: RelatorioDeProdutoComponent},
    {path:'transferenciaDeProduto',
    component: TransferenciaDeProdutoComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }