import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HomeComponent } from './home/home.component';
import { CadastroDeFornecedorComponent } from './abastecimento/cadastro-de-fornecedor/cadastro-de-fornecedor.component';
import { CadastroDeProdutoComponent } from './abastecimento/cadastro-de-produto/cadastro-de-produto.component';
import { DashboardComponent } from './abastecimento/dashboard/dashboard.component';
import { EntradaDeProdutoComponent } from './abastecimento/entrada-de-produto/entrada-de-produto.component';
import { RelatorioDeEstoqueComponent } from './abastecimento/relatorio-de-estoque/relatorio-de-estoque.component';
import { RelatorioDeProdutoComponent } from './abastecimento/relatorio-de-produto/relatorio-de-produto.component';
import { TransferenciaDeProdutoComponent } from './abastecimento/transferencia-de-produto/transferencia-de-produto.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    HomeComponent,
    CadastroDeFornecedorComponent,
    CadastroDeProdutoComponent,
    DashboardComponent,
    EntradaDeProdutoComponent,
    RelatorioDeEstoqueComponent,
    RelatorioDeProdutoComponent,
    TransferenciaDeProdutoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
