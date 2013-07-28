package br.com.hfsuprimento.model;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class CotacaoModel extends BaseModel  {
		
 	private StatusCotacaoModel statusCotacaoModel; 
    private CondicaoPagamentoModel condicaoPagamentoModel;
	private Date dataValidade;
	private Date dataEnvio;
	private String nomeLogradouro;  
	private boolean flagFechado;
	
	private List<CotacaoProdutoModel> cotacaoProdutos;		
	
	public CotacaoModel() {
		
	}
	
	public CotacaoModel(Long id) {
		this.id = id;
	}
	
	public StatusCotacaoModel getStatusCotacaoModel() {
		return statusCotacaoModel;
	}
	
	public void setStatusCotacaoModel(StatusCotacaoModel statusCotacaoModel) {
		this.statusCotacaoModel = statusCotacaoModel;
	}
	
	public CondicaoPagamentoModel getCondicaoPagamentoModel() {
		return condicaoPagamentoModel;
	}
	
	public void setCondicaoPagamentoModel(
			CondicaoPagamentoModel condicaoPagamentoModel) {
		this.condicaoPagamentoModel = condicaoPagamentoModel;
	}
	
	public Date getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public Date getDataEnvio() {
		return dataEnvio;
	}
	
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public List<CotacaoProdutoModel> getCotacaoProdutos() {
		return cotacaoProdutos;
	}

	public void setCotacaoProdutos(List<CotacaoProdutoModel> cotacaoProdutos) {
		this.cotacaoProdutos = cotacaoProdutos;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public boolean isFlagFechado() {
		return flagFechado;
	}

	public void setFlagFechado(boolean flagFechado) {
		this.flagFechado = flagFechado;
	}

		
		
	
}
