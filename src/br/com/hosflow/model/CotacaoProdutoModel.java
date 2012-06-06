package br.com.hosflow.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CotacaoProdutoModel implements Serializable {

	private Long id;
	private CotacaoModel cotacaoModel;
	private ProdutoModel produtoModel;
	
	private Double quantidadeAtual;
	private Double quantidadeSolicitada;
	private Double quantidadeLiberada;
	private Boolean flagAtivo;
	private Long aprovacao;
		
	private List<CotacaoProdutoFornecedorModel> cotacaoProdutoFornecedores;
	
	public CotacaoProdutoModel() {
		
	}
	
	public CotacaoProdutoModel(CotacaoModel cotacaoModel) {
		
		this.cotacaoModel = cotacaoModel;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public CotacaoModel getCotacaoModel() {
		return cotacaoModel;
	}
	
	public void setCotacaoModel(CotacaoModel cotacaoModel) {
		this.cotacaoModel = cotacaoModel;
	}
	
	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}
	
	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}
	
	public Boolean getFlagAtivo() {
		return flagAtivo;
	}
	
	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	
	public Double getQuantidadeAtual() {
		return quantidadeAtual;
	}
	
	public void setQuantidadeAtual(Double quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}
	
	public Double getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}
	
	public void setQuantidadeSolicitada(Double quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}
	
	public Double getQuantidadeLiberada() {
		return quantidadeLiberada;
	}
	
	public void setQuantidadeLiberada(Double quantidadeLiberada) {
		this.quantidadeLiberada = quantidadeLiberada;
	}

	public List<CotacaoProdutoFornecedorModel> getCotacaoProdutoFornecedores() {
		return cotacaoProdutoFornecedores;
	}

	public void setCotacaoProdutoFornecedores(List<CotacaoProdutoFornecedorModel> cotacaoProdutoFornecedores) {
		this.cotacaoProdutoFornecedores = cotacaoProdutoFornecedores;
	}

	public Long getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(Long aprovacao) {
		this.aprovacao = aprovacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produtoModel == null) ? 0 : produtoModel.hashCode());
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
		CotacaoProdutoModel other = (CotacaoProdutoModel) obj;
		if (produtoModel == null) {
			if (other.produtoModel != null)
				return false;
		} else if (!produtoModel.equals(other.produtoModel))
			return false;
		return true;
	}
		
}
