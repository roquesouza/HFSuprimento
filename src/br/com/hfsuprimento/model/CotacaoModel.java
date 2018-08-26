package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CotacaoModel implements Serializable {

	private Long id;
	private UsuarioModel usuarioCadastroModel;
	private UsuarioModel usuarioAtualizacaoModel;
	private Date dataCadastro;
	private Date dataAtualizacao;
	private Boolean flagAtivo;
	private StatusCotacaoModel statusCotacaoModel;
	private CondicaoPagamentoModel condicaoPagamentoModel;
	private Date dataValidade;
	private Date dataInicial;
	private Date dataFinal;
	private String condicaoPagamento;
	private String frete;
	private String prazoEntrega;

	private List<CotacaoProdutoModel> cotacaoProdutos;

	public CotacaoModel(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return TSUtil.tratarLong(id);
	}

	public CotacaoModel() {

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

	public void setCondicaoPagamentoModel(CondicaoPagamentoModel condicaoPagamentoModel) {
		this.condicaoPagamentoModel = condicaoPagamentoModel;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public List<CotacaoProdutoModel> getCotacaoProdutos() {
		return cotacaoProdutos;
	}

	public void setCotacaoProdutos(List<CotacaoProdutoModel> cotacaoProdutos) {
		this.cotacaoProdutos = cotacaoProdutos;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public UsuarioModel getUsuarioCadastroModel() {
		return usuarioCadastroModel;
	}

	public void setUsuarioCadastroModel(UsuarioModel usuarioCadastroModel) {
		this.usuarioCadastroModel = usuarioCadastroModel;
	}

	public UsuarioModel getUsuarioAtualizacaoModel() {
		return usuarioAtualizacaoModel;
	}

	public void setUsuarioAtualizacaoModel(UsuarioModel usuarioAtualizacaoModel) {
		this.usuarioAtualizacaoModel = usuarioAtualizacaoModel;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public void setId(Long id) {
		this.id = id;
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
		CotacaoModel other = (CotacaoModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
