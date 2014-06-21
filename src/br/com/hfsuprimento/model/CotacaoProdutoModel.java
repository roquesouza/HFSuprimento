package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hfsuprimento.util.Utilitario;
import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CotacaoProdutoModel implements Serializable {

	private Long id;
	private CotacaoModel cotacaoModel;
	private ProdutoModel produtoModel;
	private String observacao;
	private Double quantidadeAtual;
	private Double quantidadeSugerida;
	private Double quantidadeSolicitada;
	private Boolean flagAtivo;
	private UsuarioModel usuarioLiberacaoModel;
	private Date dataLiberacao;
	private Boolean flagLiberada;
	
	private List<CotacaoProdutoFornecedorModel> cotacaoProdutoFornecedores;
	
	public CotacaoProdutoModel(CotacaoModel cotacaoModel) {
		super();
		this.cotacaoModel = cotacaoModel;
	}

	public CotacaoProdutoModel() {
		super();
	}

	public Long getId() {
		return TSUtil.tratarLong(id);
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
		return Utilitario.tratarDouble(quantidadeSolicitada);
	}
	
	public void setQuantidadeSolicitada(Double quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}
	
	public List<CotacaoProdutoFornecedorModel> getCotacaoProdutoFornecedores() {
		return cotacaoProdutoFornecedores;
	}

	public void setCotacaoProdutoFornecedores(List<CotacaoProdutoFornecedorModel> cotacaoProdutoFornecedores) {
		this.cotacaoProdutoFornecedores = cotacaoProdutoFornecedores;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Double getQuantidadeSugerida() {
		return quantidadeSugerida;
	}

	public void setQuantidadeSugerida(Double quantidadeSugerida) {
		this.quantidadeSugerida = quantidadeSugerida;
	}

	public UsuarioModel getUsuarioLiberacaoModel() {
		return usuarioLiberacaoModel;
	}

	public void setUsuarioLiberacaoModel(UsuarioModel usuarioLiberacaoModel) {
		this.usuarioLiberacaoModel = usuarioLiberacaoModel;
	}

	public Date getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(Date dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public Boolean getFlagLiberada() {
		return flagLiberada;
	}

	public void setFlagLiberada(Boolean flagLiberada) {
		this.flagLiberada = flagLiberada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotacaoModel == null) ? 0 : cotacaoModel.hashCode());
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
		if (cotacaoModel == null) {
			if (other.cotacaoModel != null)
				return false;
		} else if (!cotacaoModel.equals(other.cotacaoModel))
			return false;
		if (produtoModel == null) {
			if (other.produtoModel != null)
				return false;
		} else if (!produtoModel.equals(other.produtoModel))
			return false;
		return true;
	}
		
}
