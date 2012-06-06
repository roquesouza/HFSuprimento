package br.com.hosflow.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class ProdutoModel implements Serializable {

	private Long id;
	private String nomePrincipal;
	private String nomeFantasia;
	private CategoriaModel categoriaModel;
	private UnidadeMedidaModel unidadeMedidaModel;
	private Boolean flagVincularPaciente;
	private Boolean flagAtivo;
	private String dataCadastro;
	private String referenciaTecnica;
	private BigDecimal quantidadeMaxima;
	private BigDecimal quantidadeMinima;
	private Integer tempoResuprimento;
	private String detalheInteracao;
	private List<ProdutoModel> produtosInterados;
	private BigDecimal quantidadeKit;
	private BigDecimal precoMedio;
	private BigDecimal quantidadeEstoque;
	private Boolean flagLote;
	private BigDecimal dosagemPadrao;
	private Boolean flagPrescricao;

	public ProdutoModel() {

	}

	public ProdutoModel(Long id) {

		this.id = id;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getNomePrincipal() {

		return nomePrincipal;
	}

	public void setNomePrincipal(String nomePrincipal) {

		this.nomePrincipal = nomePrincipal;
	}

	public String getNomeFantasia() {

		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

	public Boolean getFlagVincularPaciente() {

		return flagVincularPaciente;
	}

	public void setFlagVincularPaciente(Boolean flagVincularPaciente) {

		this.flagVincularPaciente = flagVincularPaciente;
	}

	public Boolean getFlagAtivo() {

		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {

		this.flagAtivo = flagAtivo;
	}

	public String getDataCadastro() {

		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {

		this.dataCadastro = dataCadastro;
	}

	public String getReferenciaTecnica() {

		return referenciaTecnica;
	}

	public void setReferenciaTecnica(String referenciaTecnica) {

		this.referenciaTecnica = referenciaTecnica;
	}

	public Integer getTempoResuprimento() {

		return tempoResuprimento;
	}

	public void setTempoResuprimento(Integer tempoResuprimento) {

		this.tempoResuprimento = tempoResuprimento;
	}

	public String getSituacao() {

		return !TSUtil.isEmpty(flagAtivo) && flagAtivo.equals(Boolean.TRUE) ? "Ativo" : "Inativo";
	}

	public String getDetalheInteracao() {

		return detalheInteracao;
	}

	public void setDetalheInteracao(String detalheInteracao) {

		this.detalheInteracao = detalheInteracao;
	}

	public List<ProdutoModel> getProdutosInterados() {

		return produtosInterados;
	}

	public void setProdutosInterados(List<ProdutoModel> produtosInterados) {

		this.produtosInterados = produtosInterados;
	}

	public String getNomeFantasiaPesquisa() {

		if (TSUtil.isEmpty(this.nomeFantasia)) {
			return null;
		}
		return "%" + this.nomeFantasia + "%";
	}

	public BigDecimal getQuantidadeKit() {

		return quantidadeKit;
	}

	public void setQuantidadeKit(BigDecimal quantidadeKit) {

		this.quantidadeKit = quantidadeKit;
	}

	public BigDecimal getPrecoMedio() {

		return precoMedio;
	}

	public void setPrecoMedio(BigDecimal precoMedio) {

		this.precoMedio = precoMedio;
	}

	public BigDecimal getQuantidadeMaxima() {

		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(BigDecimal quantidadeMaxima) {

		this.quantidadeMaxima = quantidadeMaxima;
	}

	public BigDecimal getQuantidadeMinima() {

		return quantidadeMinima;
	}

	public void setQuantidadeMinima(BigDecimal quantidadeMinima) {

		this.quantidadeMinima = quantidadeMinima;
	}

	public String getProdutoDetalhado() {

		if (!TSUtil.isEmpty(this.getId()) && !TSUtil.isEmpty(this.nomePrincipal)) {

			return this.getId() + ": " + this.nomePrincipal;

		}

		else {
			return "";
		}
	}

	public Boolean getFlagLote() {

		return flagLote;
	}

	public void setFlagLote(Boolean flagLote) {

		this.flagLote = flagLote;
	}

	public BigDecimal getQuantidadeEstoque() {

		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {

		this.quantidadeEstoque = quantidadeEstoque;
	}

	public BigDecimal getDosagemPadrao() {

		return dosagemPadrao;
	}

	public void setDosagemPadrao(BigDecimal dosagemPadrao) {

		this.dosagemPadrao = dosagemPadrao;
	}

	public Boolean getFlagPrescricao() {

		return flagPrescricao;
	}

	public void setFlagPrescricao(Boolean flagPrescricao) {

		this.flagPrescricao = flagPrescricao;
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
		ProdutoModel other = (ProdutoModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
