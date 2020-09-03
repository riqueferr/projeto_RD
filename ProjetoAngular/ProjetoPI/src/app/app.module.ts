import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
// import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';
import { NgxPaginationModule } from 'ngx-pagination'; // Módulo da dependência de paginação


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
import { CupomDeVendaComponent } from './financeiro/cupom-de-venda/cupom-de-venda.component';
import { FinanceiroDashboardComponent } from './financeiro/financeiro-dashboard/financeiro-dashboard.component';
import { RelatorioGerencialComponent } from './financeiro/relatorio-gerencial/relatorio-gerencial.component';
import { MovimentoDeLojaComponent } from './financeiro/movimento-de-loja/movimento-de-loja.component';
import { ListaFornecedoresComponent } from './abastecimento/lista-fornecedores/lista-fornecedores.component';
import { DetalhamentoCupomDeVendasComponent } from './financeiro/detalhamento-cupom-de-vendas/detalhamento-cupom-de-vendas.component';
import { ListaProdutosComponent } from './abastecimento/lista-produtos/lista-produtos.component';
import { EditarProdutosComponent } from './abastecimento/lista-produtos/editar-produtos/editar-produtos.component';
import { EditarFornecedoresComponent } from './abastecimento/lista-fornecedores/editar-fornecedores/editar-fornecedores.component';
import { ListaEntradaComponent } from './abastecimento/lista-entrada/lista-entrada.component';
import { MyBarChartOneComponent } from './abastecimento/dashboard/my-bar-chart-one/my-bar-chart-one.component';
import { DetalhamentoFornecedoresComponent } from './abastecimento/lista-fornecedores/detalhamento-fornecedores/detalhamento-fornecedores.component';
import { ListaTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-transferencia/lista-transferencia.component';
import { LoginComponent } from './login/login.component';
import { ListarIdFilialComponent } from './abastecimento/relatorio-de-estoque/listar-id-filial/listar-id-filial.component';
import { NgxMaskModule, IConfig } from 'ngx-mask';
import { ListaIdEntradaComponent } from './abastecimento/lista-entrada/lista-id-entrada/lista-id-entrada.component';
import { ListarPageFornecedoresComponent } from './abastecimento/lista-fornecedores/listar-page-fornecedores/listar-page-fornecedores.component';



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
    TransferenciaDeProdutoComponent,
    CupomDeVendaComponent,
    FinanceiroDashboardComponent,
    RelatorioGerencialComponent,
    MovimentoDeLojaComponent,
    ListaFornecedoresComponent,
    DetalhamentoCupomDeVendasComponent,
    ListaProdutosComponent,
    EditarProdutosComponent,
    EditarFornecedoresComponent,
    ListaEntradaComponent,
    MyBarChartOneComponent,
    DetalhamentoFornecedoresComponent,
    ListaTransferenciaComponent,
    LoginComponent,
    ListarIdFilialComponent,
    ListaIdEntradaComponent,
    ListarPageFornecedoresComponent,
  ],
  imports: [
    BrowserModule,
    // ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    // MoneyMaskModule,
    NgxMaskModule.forRoot(),
    NgxPaginationModule // Nosso módulo recém instalado
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
