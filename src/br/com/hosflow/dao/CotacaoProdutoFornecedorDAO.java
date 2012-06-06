package br.com.hosflow.dao;

import java.util.List;

import br.com.hosflow.model.CotacaoModel;
import br.com.hosflow.model.CotacaoProdutoFornecedorModel;
import br.com.hosflow.model.CotacaoProdutoModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;

public final class CotacaoProdutoFornecedorDAO {

	@SuppressWarnings("unchecked")
	public List<CotacaoProdutoFornecedorModel> pesquisar(final CotacaoProdutoModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.pesquisarporproduto", model.getProdutoModel().getId(), model.getCotacaoModel().getId());

		return broker.getCollectionBean(CotacaoProdutoFornecedorModel.class, "fornecedorModel.id", "cotacaoProdutoModel.id");

	}
	
	@SuppressWarnings("unchecked")
	public List<CotacaoProdutoFornecedorModel> pesquisar(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.pesquisar", model.getCotacaoProdutoModel().getId());

		return broker.getCollectionBean(CotacaoProdutoFornecedorModel.class, "id", "fornecedorModel.id", "fornecedorModel.identificador", "fornecedorModel.nomeFantasia", "valor", "flagSelecionado");

	}
	
	@SuppressWarnings("unchecked")
	public List<CotacaoProdutoFornecedorModel> pesquisarPorFornecedor(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.pesquisarporfornecedor", model.getCotacaoProdutoModel().getId(), model.getFornecedorModel().getId());

		return broker.getCollectionBean(CotacaoProdutoFornecedorModel.class, "id", "cotacaoProdutoModel.cotacaoModel.id", "cotacaoProdutoModel.cotacaoModel.dataEnvio", "cotacaoProdutoModel.cotacaoModel.dataValidade", "cotacaoProdutoModel.produtoModel.id", "cotacaoProdutoModel.produtoModel.nomePrincipal", "cotacaoProdutoModel.produtoModel.unidadeMedidaModel.descricao", "cotacaoProdutoModel.quantidadeSolicitada", "cotacaoProdutoModel.quantidadeLiberada", "valor");

	}

	public int inserir(CotacaoModel model) throws TSApplicationException {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.inserir", model.getId());

		return broker.execute();

	}
	
	public CotacaoProdutoFornecedorModel alterar(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.alterar", model.getValor(), model.getId());

		broker.execute();

		return null;
	}

	public void selecionarCotacaoProdutoFornecedor(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.liberarcotacao", model.getFlagSelecionado(), model.getId());

		broker.execute();

	}

}
