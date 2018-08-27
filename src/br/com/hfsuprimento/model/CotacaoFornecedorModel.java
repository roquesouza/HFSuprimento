package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CotacaoFornecedorModel implements Serializable {

	private Long id;
	
	private CotacaoModel cotacaoModel;
	
	private FornecedorModel fornecedorModel;
	
	private Date dataAtualizacao;

	private String condicaoPagamento;
	
	private String frete;
	
	private String prazoEntrega;
	
	
	private List<CotacaoProdutoFornecedorModel> grid;
	
	public CotacaoFornecedorModel() {

	}

	public CotacaoFornecedorModel(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return TSUtil.tratarLong(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FornecedorModel getFornecedorModel() {
		return fornecedorModel;
	}

	public void setFornecedorModel(FornecedorModel fornecedorModel) {
		this.fornecedorModel = fornecedorModel;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public List<CotacaoProdutoFornecedorModel> getGrid() {
		return grid;
	}

	public void setGrid(List<CotacaoProdutoFornecedorModel> grid) {
		this.grid = grid;
	}

	public CotacaoModel getCotacaoModel() {
		return cotacaoModel;
	}

	public void setCotacaoModel(CotacaoModel cotacaoModel) {
		this.cotacaoModel = cotacaoModel;
	}

	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public String getFrete() {
		return frete;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoFornecedorModel other = (CotacaoFornecedorModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
