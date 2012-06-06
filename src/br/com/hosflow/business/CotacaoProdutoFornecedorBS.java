package br.com.hosflow.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.hosflow.dao.CotacaoProdutoFornecedorDAO;
import br.com.hosflow.model.CotacaoModel;
import br.com.hosflow.model.CotacaoProdutoFornecedorModel;
import br.com.hosflow.model.CotacaoProdutoModel;
import br.com.topsys.exception.TSApplicationException;

@LocalBean
@Stateless
public class CotacaoProdutoFornecedorBS {

	@Inject
	CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO;

	public int inserir(CotacaoModel model) throws TSApplicationException {

		return cotacaoProdutoFornecedorDAO.inserir(model);

	}

	public CotacaoProdutoFornecedorModel alterar(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		return cotacaoProdutoFornecedorDAO.alterar(model);

	}

	public List<CotacaoProdutoFornecedorModel> pesquisar(CotacaoProdutoModel model) {

		return cotacaoProdutoFornecedorDAO.pesquisar(model);

	}

	public List<CotacaoProdutoFornecedorModel> pesquisar(CotacaoProdutoFornecedorModel model) {

		return cotacaoProdutoFornecedorDAO.pesquisar(model);

	}

	public List<CotacaoProdutoFornecedorModel> pesquisarPorFornecedor(CotacaoProdutoFornecedorModel model) {
		return cotacaoProdutoFornecedorDAO.pesquisarPorFornecedor(model);
	}

	public void selecionarCotacaoProdutoFornecedor(CotacaoProdutoFornecedorModel model) throws TSApplicationException {

		cotacaoProdutoFornecedorDAO.selecionarCotacaoProdutoFornecedor(model);
		
	}

}
