package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.util.List;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class ProdutoModel implements Serializable {

	private Long id;
	private String nomePrincipal;
	private String nomeFantasia;
	private CategoriaModel categoriaModel;
	private UnidadeMedidaModel unidadeMedidaModel;
	private Boolean flagAtivo;
	private List<FabricanteModel> fabricantesAutorizados;

	public ProdutoModel() {

	}

	public ProdutoModel(Long id) {
		this.id = id;
	}

	public Long getId() {
		return TSUtil.tratarLong(id);
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

	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	public UnidadeMedidaModel getUnidadeMedidaModel() {
		return unidadeMedidaModel;
	}

	public void setUnidadeMedidaModel(UnidadeMedidaModel unidadeMedidaModel) {
		this.unidadeMedidaModel = unidadeMedidaModel;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public List<FabricanteModel> getFabricantesAutorizados() {
		return fabricantesAutorizados;
	}

	public void setFabricantesAutorizados(List<FabricanteModel> fabricantesAutorizados) {
		this.fabricantesAutorizados = fabricantesAutorizados;
	}

}
