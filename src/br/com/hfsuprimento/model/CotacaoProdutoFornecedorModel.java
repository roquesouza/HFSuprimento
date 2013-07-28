package br.com.hfsuprimento.model;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CotacaoProdutoFornecedorModel extends BaseModel {

	private CotacaoProdutoModel cotacaoProdutoModel;
	private FornecedorModel fornecedorModel;
	private Double valor;
	private boolean flagSelecionado;
	private Integer fornecedorSelecionado;

	public CotacaoProdutoFornecedorModel() {

	}

	public CotacaoProdutoFornecedorModel(Long id) {
		this.id = id;
	}

	public CotacaoProdutoFornecedorModel(CotacaoProdutoModel cotacaoProdutoModel) {
		this.cotacaoProdutoModel = cotacaoProdutoModel;
	}

	public CotacaoProdutoModel getCotacaoProdutoModel() {
		return cotacaoProdutoModel;
	}

	public void setCotacaoProdutoModel(CotacaoProdutoModel cotacaoProdutoModel) {
		this.cotacaoProdutoModel = cotacaoProdutoModel;
	}

	public FornecedorModel getFornecedorModel() {
		return fornecedorModel;
	}

	public void setFornecedorModel(FornecedorModel fornecedorModel) {
		this.fornecedorModel = fornecedorModel;
	}

	public Boolean getFlagSelecionado() {
		return flagSelecionado;
	}

	public void setFlagSelecionado(Boolean flagSelecionado) {
		this.flagSelecionado = flagSelecionado;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorTotal() {

		if (!TSUtil.isEmpty(getValor()) && !TSUtil.isEmpty(cotacaoProdutoModel.getQuantidadeLiberada())) {

			return valor * cotacaoProdutoModel.getQuantidadeLiberada();

		} else {

			return 0D;

		}

	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getFornecedorSelecionado() {

		if (!TSUtil.isEmpty(this.flagSelecionado) && this.flagSelecionado) {

			this.fornecedorSelecionado = 1;

		} else {

			this.fornecedorSelecionado = 2;
		}
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Integer fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

}
