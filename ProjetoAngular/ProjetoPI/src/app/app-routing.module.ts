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
import { MyBarChartOneComponent } from './abastecimento/dashboard/my-bar-chart-one/my-bar-chart-one.component';
import { DetalhamentoFornecedoresComponent } from './abastecimento/lista-fornecedores/detalhamento-fornecedores/detalhamento-fornecedores.component';
import { ListaTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-transferencia/lista-transferencia.component';
import { LoginComponent } from './login/login.component';
import { ListarIdFilialComponent } from './abastecimento/relatorio-de-estoque/listar-id-filial/listar-id-filial.component';
import { ListaIdEntradaComponent } from './abastecimento/lista-entrada/lista-id-entrada/lista-id-entrada.component';
import { ListarPageFornecedoresComponent } from './abastecimento/lista-fornecedores/listar-page-fornecedores/listar-page-fornecedores.component';
import { AuthGuard } from './guards/auth.guard';
import { ListaNmfilialEntradaComponent } from './abastecimento/lista-entrada/lista-nmfilial-entrada/lista-nmfilial-entrada.component';
import { ListarNomeFilialComponent } from './abastecimento/relatorio-de-estoque/listar-nome-filial/listar-nome-filial.component';
import { ListaNomeProdutoRelatorioComponent } from './abastecimento/relatorio-de-produto/lista-nome-produto-relatorio/lista-nome-produto-relatorio.component';
import { ListaStatusProdutoRelatorioComponent } from './abastecimento/relatorio-de-produto/lista-status-produto-relatorio/lista-status-produto-relatorio.component';
import { ListaIdTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-id-transferencia/lista-id-transferencia.component';
import { ListaFilialdestinoTransferenciaComponent } from './abastecimento/transferencia-de-produto/lista-filialdestino-transferencia/lista-filialdestino-transferencia.component';
import { ListaIdProdutoComponent } from './abastecimento/lista-produtos/lista-id-produto/lista-id-produto.component';
import { ListaIdFornecedorComponent } from './abastecimento/lista-fornecedores/lista-id-fornecedor/lista-id-fornecedor.component';
import { DetalhamentoProdutosComponent } from './abastecimento/lista-produtos/detalhamento-produtos/detalhamento-produtos.component';


export const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
    // canActivate: [AuthGuard]
  },
  {
    path: 'abastecimento-dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cadastroDeFornecedor',
    component: CadastroDeFornecedorComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cadastroDeProduto',
    component: CadastroDeProdutoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'entradaDeProduto',
    component: EntradaDeProdutoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeEstoque',
    component: RelatorioDeEstoqueComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeEstoque/filial/:cdFilial',
    component: ListarIdFilialComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeEstoque/nomefilial/:nmFilial',
    component: ListarNomeFilialComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeProduto',
    component: RelatorioDeProdutoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeProduto/nomeproduto/:nmProduto',
    component: ListaNomeProdutoRelatorioComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioDeProduto/statusproduto/:statusProduto',
    component: ListaStatusProdutoRelatorioComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'transferenciaDeProduto',
    component: TransferenciaDeProdutoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cupomDeVenda',
    component: CupomDeVendaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'financeiro-dashboard',
    component: FinanceiroDashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'movimentoDeLoja',
    component: MovimentoDeLojaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'relatorioGerencial',
    component: RelatorioGerencialComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaFornecedores',
    component: ListaFornecedoresComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaFornecedores/:idFornecedor',
    component: ListaIdFornecedorComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaEntradaProdutos',
    component: ListaEntradaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaEntradaProdutos/:idDF',
    component: ListaIdEntradaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaEntradaProdutos/filial/:nmFilial',
    component: ListaNmfilialEntradaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaFornecedores/:page',
    component: ListarPageFornecedoresComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaProdutos',
    component: ListaProdutosComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaProdutos/:idProduto',
    component: ListaIdProdutoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaTransferenciaProduto',
    component: ListaTransferenciaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaTransferenciaProduto/:idDF',
    component: ListaIdTransferenciaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaTransferenciaProduto/filial/:nmFilialDestino',
    component: ListaFilialdestinoTransferenciaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'listaProdutos/:nm_fantasia',
    component: ListaProdutosComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'detalhamentoCupomDeVendas/:idDF',
    component: DetalhamentoCupomDeVendasComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'visualizar/fornecedor/:cd_fornecedor',
    component: DetalhamentoFornecedoresComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'visualizar/produto/:codigo',
    component: DetalhamentoProdutosComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'produtos/editar/:codigo',
    component: EditarProdutosComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'fornecedores/editar/:cd_fornecedor',
    component: EditarFornecedoresComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'graficoAbastecimentoDrogasil',
    component: MyBarChartOneComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule { }
