package br.com.hfsuprimento.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.hfsuprimento.model.FabricanteModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public final class CotacaoProdutoFornecedorDAO implements Serializable {

	public CotacaoProdutoFornecedorModel obter(String hash) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setSQL("SELECT DISTINCT CF.COTACAO_ID, C.CONDICAO_PAGAMENTO, C.FRETE, C.PRAZO_ENTREGA, F.ID, F.NOME_FANTASIA FROM FORNECEDOR F, COTACAO_FORNECEDOR CF, COTACAO C WHERE F.ID = CF.FORNECEDOR_ID AND C.ID = CF.COTACAO_ID AND C.STATUS_COTACAO_ID = 2 AND C.DATA_VALIDADE >= CURRENT_DATE AND MD5(CF.ID::TEXT) = ?", hash);

		CotacaoProdutoFornecedorModel model = (CotacaoProdutoFornecedorModel) broker.getObjectBean(CotacaoProdutoFornecedorModel.class, "cotacaoProdutoModel.cotacaoModel.id", "cotacaoProdutoModel.cotacaoModel.condicaoPagamento", "cotacaoProdutoModel.cotacaoModel.frete", "cotacaoProdutoModel.cotacaoModel.prazoEntrega", "fornecedorModel.id", "fornecedorModel.nomeFantasia");

		if (!TSUtil.isEmpty(model)) {

			model.setGrid(this.pesquisar(model));

		}

		return model;

	}

	@SuppressWarnings("unchecked")
	public List<CotacaoProdutoFornecedorModel> pesquisar(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setSQL("SELECT CPF.ID, CP.COTACAO_ID, CP.PRODUTO_ID, PRO.NOME_PRINCIPAL, UM.DESCRICAO, CP.QUANTIDADE_SOLICITADA, CP.OBSERVACAO, CPF.COTACAO_PRODUTO_ID, CPF.FORNECEDOR_ID, F.NOME_FANTASIA, CPF.VALOR, CPF.VALOR_TOTAL, CPF.OBSERVACAO, CPF.DATA_ATUALIZACAO, CPF.FABRICANTE_ID, (SELECT F2.NOME FROM FABRICANTE F2 WHERE F2.ID = CPF.FABRICANTE_ID), PESQUISAR_FABRICANTES(PRO.ID), CPF.FABRICANTE, CPF.QTD_CAIXA FROM COTACAO_PRODUTO_FORNECEDOR CPF, COTACAO_PRODUTO CP, PRODUTO PRO, UNIDADE_MEDIDA UM, FORNECEDOR F WHERE CPF.COTACAO_PRODUTO_ID = CP.ID AND PRO.ID = CP.PRODUTO_ID AND UM.ID = PRO.UNIDADE_MEDIDA_ID AND F.ID = CPF.FORNECEDOR_ID AND CP.COTACAO_ID = ? AND CPF.FORNECEDOR_ID = ? ORDER BY PRO.NOME_PRINCIPAL", model.getCotacaoProdutoModel().getCotacaoModel().getId(), model.getFornecedorModel().getId());

		return broker.getCollectionBean(CotacaoProdutoFornecedorModel.class, "id", "cotacaoProdutoModel.cotacaoModel.id", "cotacaoProdutoModel.produtoModel.id", "cotacaoProdutoModel.produtoModel.nomePrincipal", "cotacaoProdutoModel.produtoModel.unidadeMedidaModel.descricao", "cotacaoProdutoModel.quantidadeSolicitada", "cotacaoProdutoModel.observacao", "cotacaoProdutoModel.id", "fornecedorModel.id", "fornecedorModel.nomeFantasia", "valor", "valorTotal", "observacao", "dataAtualizacao", "fabricanteModel.id", "fabricanteModel.nome", "fabricantesSugeridos", "fabricante", "qtdCaixa");

	}

	@SuppressWarnings("unchecked")
	public List<FabricanteModel> pesquisarFabricantesAutorizados(CotacaoProdutoFornecedorModel model) {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setSQL("SELECT F.ID, F.NOME FROM FABRICANTE F, PRODUTO_FABRICANTE PF WHERE PF.FABRICANTE_ID = F.ID AND PF.PRODUTO_ID = ? ORDER BY F.NOME", model.getCotacaoProdutoModel().getProdutoModel().getId());

		return broker.getCollectionBean(FabricanteModel.class, "id", "nome");

	}

	public CotacaoProdutoFornecedorModel alterar(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

		broker.setSQL("UPDATE COTACAO_PRODUTO_FORNECEDOR SET VALOR = ?, VALOR_TOTAL = ?, FABRICANTE = ?, QTD_CAIXA = ?, OBSERVACAO = ?, DATA_ATUALIZACAO = ?, USUARIO_ATUALIZACAO_ID = NULL WHERE ID = ?", model.getValor(), model.getValorTotal(), model.getFabricante(), model.getQtdCaixa(), model.getObservacao(), new Timestamp(model.getDataAtualizacao().getTime()), model.getId());

		broker.execute();

		return null;
	}

}
