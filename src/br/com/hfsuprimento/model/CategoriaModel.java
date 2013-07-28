package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CategoriaModel implements Serializable {
	
	private Long id;
	private String descricao;
	private CategoriaModel categoriaModel;
	private Boolean flagAtivo;
	private String dataCadastro;
	private boolean flagEditavel;
	private BigDecimal valorDebitoTransacao;
	private Boolean flagMedicamento;
	
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
	
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
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
		CategoriaModel other = (CategoriaModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String getSituacao() {
	    return !TSUtil.isEmpty(flagAtivo) && flagAtivo.equals(Boolean.TRUE) ? "Ativo" : "Inativo";
  }

	public boolean getFlagEditavel() {
		return flagEditavel;
	}

	public void setFlagEditavel(boolean flagEditavel) {
		this.flagEditavel = flagEditavel;
	}

	public BigDecimal getValorDebitoTransacao() {
		return valorDebitoTransacao;
	}

	public void setValorDebitoTransacao(BigDecimal valorDebitoTransacao) {
		this.valorDebitoTransacao = valorDebitoTransacao;
	}

	public Boolean getFlagMedicamento() {
    
    	return flagMedicamento;
    }

	public void setFlagMedicamento(Boolean flagMedicamento) {
    
    	this.flagMedicamento = flagMedicamento;
    }
	
	

}
