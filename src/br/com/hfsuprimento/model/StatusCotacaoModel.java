package br.com.hfsuprimento.model;

import java.io.Serializable;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class StatusCotacaoModel implements Serializable {

	  private Long id;
	  private String descricao;
	  private Boolean flagFechado;

	  public StatusCotacaoModel () {

	  }

	  public StatusCotacaoModel (Long id) {
	    this.id = id;
	  }

	  public Long getId() {   
	    return TSUtil.tratarLong(id);
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

	public Boolean getFlagFechado() {
		return flagFechado;
	}

	public void setFlagFechado(Boolean flagFechado) {
		this.flagFechado = flagFechado;
	}

}
