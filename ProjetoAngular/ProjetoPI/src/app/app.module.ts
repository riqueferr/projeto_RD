import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
// import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';
import { NgxPaginationModule } from 'ngx-pagination'; // Módulo da dependência de paginação
import { NgxCurrencyModule } from 'ngx-currency';
import { ReactiveFormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';

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
import { ListarPageFornecedoresComponent } from './abastecimento/lista-fornecedores/listar-page-fornecedores/listar-page-fornecedores.component';
import { ListaIdEntradaComponent } from './abastecimento/lista-entrada/lista-id-entrada/lista-id-entrada.component'
import { AuthService } from './login/auth.service';
import { AuthGuard } from './guards/auth.guard';
import { ListaNmfilialEntradaComponent } from './abastecimento/lista-entrada/lista-nmfilial-entrada/lista-nmfilial-entrada.component';
import { ListarNomeFilialComponent } from './abastecimento/relatorio-de-estoque/listar-nome-filial/listar-nome-filial.component';
import { ListaNomeProdutoRelatorioComponent } from './abastecimento/relatorio-de-produto/lista-nome-produto-relatorio/lista-nome-produto-relatorio.component';
import { ListaStatusProdutoRelatorioComponent } from './abastecimento/relatorio-de-produto/lista-status-produto-relatorio/lista-status-produto-relatorio.component';
import { ListaIdTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-id-transferencia/lista-id-transferencia.component';
import { ListaFilialdestinoTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-filialdestino-transferencia/lista-filialdestino-transferencia.component';
import { ListarFilialDfComponent } from './financeiro/cupom-de-venda/listar-filial-df/listar-filial-df.component';
import { ListaIdProdutoComponent } from './abastecimento/lista-produtos/lista-id-produto/lista-id-produto.component';
import { ListaIdFornecedorComponent } from './abastecimento/lista-fornecedores/lista-id-fornecedor/lista-id-fornecedor.component';
import { SharedModule } from './abastecimento/shared/shared.module';
import { OrderModule } from 'ngx-order-pipe';
import { DetalhamentoProdutosComponent } from './abastecimento/lista-produtos/detalhamento-produtos/detalhamento-produtos.component';



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
    ListaNmfilialEntradaComponent,
    ListarNomeFilialComponent,
    ListaNomeProdutoRelatorioComponent,
    ListaStatusProdutoRelatorioComponent,
    ListaIdTransferenciaComponent,
    ListaFilialdestinoTransferenciaComponent,
    ListarFilialDfComponent,
    ListaIdProdutoComponent,
    ListaIdFornecedorComponent,
    DetalhamentoProdutosComponent,
  ],
  imports: [
    BrowserModule,
    // ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    NgxMaskModule.forRoot(),
    NgxPaginationModule, // Paginação
    NgxCurrencyModule,
    ReactiveFormsModule,
    ModalModule.forRoot(),
    SharedModule,
    OrderModule 
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
