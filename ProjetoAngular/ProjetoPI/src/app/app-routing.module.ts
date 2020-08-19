import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './abastecimento/dashboard/dashboard.component';
import { CadastroDeFornecedorComponent } from './abastecimento/cadastro-de-fornecedor/cadastro-de-fornecedor.component';
import { CadastroDeProdutoComponent } from './abastecimento/cadastro-de-produto/cadastro-de-produto.component';
import { EntradaDeProdutoComponent } from './abastecimento/entrada-de-produto/entrada-de-produto.component';

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
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }