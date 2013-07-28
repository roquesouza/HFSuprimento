package br.com.hfsuprimento.model;


@SuppressWarnings("serial")
public class CondicaoPagamentoModel extends BaseModel {


	  private String descricao;
	  private Boolean flagAtivo; 
	  
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

	  public String getSituacao() {
	    return flagAtivo == true ? "Fechado" : "Aberto";
	  }

	  public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	
}

