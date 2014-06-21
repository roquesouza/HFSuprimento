package br.com.hfsuprimento.model;

import java.io.Serializable;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class FornecedorModel implements Serializable {

	private Long id;
	private String nomeFantasia;

	public FornecedorModel() {
	}

	public FornecedorModel(Long id) {
		this.id = id;
	}

	public Long getId() {
		return TSUtil.tratarLong(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
