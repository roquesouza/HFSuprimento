package br.com.hfsuprimento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.hfsuprimento.util.Utilitario;
import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class CotacaoProdutoFornecedorModel implements Serializable {

	private Long id;
	private CotacaoProdutoModel cotacaoProdutoModel;
	private FornecedorModel fornecedorModel;
	private Double valor;
	private Date dataAtualizacao;
	private String observacao;
	private FabricanteModel fabricanteModel;
	
	private List<CotacaoProdutoFornecedorModel> grid;
	
	public CotacaoProdutoFornecedorModel() {

	}

	public CotacaoProdutoFornecedorModel(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return TSUtil.tratarLong(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CotacaoProdutoFornecedorModel(CotacaoProdutoModel cotacaoProdutoModel) {
		this.cotacaoProdutoModel = cotacaoProdutoModel;
	}

	public CotacaoProdutoModel getCotacaoProdutoModel() {
		return cotacaoProdutoModel;
	}

	public void setCotacaoProdutoModel(CotacaoProdutoModel cotacaoProdutoModel) {
		this.cotacaoProdutoModel = cotacaoProdutoModel;
	}

	public FornecedorModel getFornecedorModel() {
		return fornecedorModel;
	}

	public void setFornecedorModel(FornecedorModel fornecedorModel) {
		this.fornecedorModel = fornecedorModel;
	}

	public Double getValor() {
		return Utilitario.tratarDouble(valor);
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return TSUtil.tratarString(observacao);
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FabricanteModel getFabricanteModel() {
		return fabricanteModel;
	}

	public void setFabricanteModel(FabricanteModel fabricanteModel) {
		this.fabricanteModel = fabricanteModel;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public Double getValorTotal(){
		return this.valor * this.cotacaoProdutoModel.getQuantidadeSolicitada();
	}

	public List<CotacaoProdutoFornecedorModel> getGrid() {
		return grid;
	}

	public void setGrid(List<CotacaoProdutoFornecedorModel> grid) {
		this.grid = grid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotacaoProdutoModel == null) ? 0 : cotacaoProdutoModel.hashCode());
		result = prime * result + ((fornecedorModel == null) ? 0 : fornecedorModel.hashCode());
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
		CotacaoProdutoFornecedorModel other = (CotacaoProdutoFornecedorModel) obj;
		if (cotacaoProdutoModel == null) {
			if (other.cotacaoProdutoModel != null)
				return false;
		} else if (!cotacaoProdutoModel.equals(other.cotacaoProdutoModel))
			return false;
		if (fornecedorModel == null) {
			if (other.fornecedorModel != null)
				return false;
		} else if (!fornecedorModel.equals(other.fornecedorModel))
			return false;
		return true;
	}

}
