import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastroDeFornecedorComponent } from './abastecimento/cadastro-de-fornecedor/cadastro-de-fornecedor.component';
import { CadastroDeProdutoComponent } from './abastecimento/cadastro-de-produto/cadastro-de-produto.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {path: 'cadastroDeFornecedor', 
    component: CadastroDeFornecedorComponent},
    {path:'cadastroDeProduto',
    component: CadastroDeProdutoComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }