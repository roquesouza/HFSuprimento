package br.com.hfsuprimento.model;

import java.io.Serializable;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class FabricanteModel implements Serializable{

	private Long id;
	private String nome;

	public Long getId() {
		return TSUtil.tratarLong(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
