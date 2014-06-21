package br.com.hfsuprimento.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoriaModel implements Serializable {

	private Long id;
	private String descricao;
	private CategoriaModel categoriaModel;
	private Boolean flagAtivo;

	public CategoriaModel() {

	}

	public CategoriaModel(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

}
