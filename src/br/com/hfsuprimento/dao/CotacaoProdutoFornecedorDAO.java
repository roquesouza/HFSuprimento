package br.com.hfsuprimento.dao;

import java.sql.Timestamp;
import java.util.List;

import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.hfsuprimento.model.FabricanteModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;

public final class CotacaoProdutoFornecedorDAO {

	public CotacaoProdutoFornecedorModel obter(String hash) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.obter", hash);

		return (CotacaoProdutoFornecedorModel) broker.getObjectBean(CotacaoProdutoFornecedorModel.class, "cotacaoProdutoModel.cotacaoModel.id", "fornecedorModel.id", "fornecedorModel.nomeFantasia");

	}

	@SuppressWarnings("unchecked")
	public List<CotacaoProdutoFornecedorModel> pesquisar(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.pesquisar", model.getCotacaoProdutoModel().getCotacaoModel().getId(), model.getFornecedorModel().getId());

		return broker.getCollectionBean(CotacaoProdutoFornecedorModel.class, "id", "cotacaoProdutoModel.cotacaoModel.id", "cotacaoProdutoModel.produtoModel.id", "cotacaoProdutoModel.produtoModel.nomePrincipal", "cotacaoProdutoModel.produtoModel.unidadeMedidaModel.descricao", "cotacaoProdutoModel.quantidadeSolicitada", "cotacaoProdutoModel.observacao", "cotacaoProdutoModel.id", "fornecedorModel.id", "fornecedorModel.nomeFantasia", "valor", "observacao", "dataAtualizacao", "fabricanteModel.id", "fabricanteModel.nome");

	}

	@SuppressWarnings("unchecked")
	public List<FabricanteModel> pesquisarFabricantesAutorizados(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.pesquisarfabricantesautorizados", model.getCotacaoProdutoModel().getProdutoModel().getId());

		return broker.getCollectionBean(FabricanteModel.class, "id", "nome");

	}

	public CotacaoProdutoFornecedorModel alterar(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setPropertySQL("cotacaoprodutofornecedordao.alterar", model.getValor(), model.getFabricanteModel().getId(), model.getObservacao(), new Timestamp(model.getDataAtualizacao().getTime()), model.getId());

		broker.execute();

		return null;
	}

}
