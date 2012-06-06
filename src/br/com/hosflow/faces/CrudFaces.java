/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hosflow.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.TabChangeEvent;

import br.com.hosflow.business.CrudBS;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import br.com.topsys.web.faces.TSMainFaces;

/**
 * 
 * @author roquesouza
 */

public abstract class CrudFaces<T extends Serializable> extends TSMainFaces {

	protected T crudModel;

	protected T crudPesquisaModel;

	protected boolean alterar;
	protected List<T> grid;
	protected final static String ID_MSG_PESQUISA = "msgPesquisa";

	public CrudFaces() {

	}

	protected abstract CrudBS getCrudBS();

	public String limpar() {

		this.alterar = false;
		this.clearFields();
		return null;

	}

	public String limparPesquisa() {

		this.clearFields();
		grid = new ArrayList<T>();
		return null;

	}

	protected void validarTab(TabChangeEvent event) {

	}

	@Override
	protected String find() {

		this.grid = this.getCrudBS().pesquisar(this.crudPesquisaModel);

		TSUtil.gerarResultadoLista(grid, ID_MSG_PESQUISA);

		return null;

	}

	@Override
	protected String detail() {

		if (!TSUtil.isEmpty(this.crudModel)) {

			this.crudModel = (T) this.getCrudBS().obter(this.crudModel);

			this.alterar = true;

		}

		return SUCESSO;

	}

	@Override
	protected String insert() throws TSApplicationException {		

		boolean valido = validaCampos();
		
		super.setClearFields(valido);

		if (!valido) {
			return null;
		}

		this.getCrudBS().inserir(this.crudModel);

		super.setDefaultMessage(true);			

		return SUCESSO;

	}

	@Override
	protected String update() throws TSApplicationException {		

		super.setClearFields(false);

		if (!validaCampos()) {
			return null;
		}

		this.getCrudBS().alterar(this.crudModel);

		super.setDefaultMessage(true);

		return SUCESSO;

	}

	@Override
	protected String delete() throws TSApplicationException {

		this.getCrudBS().excluir(this.crudModel);

		grid.remove(this.crudModel);

		return SUCESSO;

	}

	protected boolean validaCampos() {

		return true;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public List<T> getGrid() {
		return grid;
	}

	public void setGrid(List<T> grid) {
		this.grid = grid;
	}

	public T getCrudModel() {
		return crudModel;
	}

	public void setCrudModel(T crudModel) {
		this.crudModel = crudModel;
	}

	public T getCrudPesquisaModel() {
		return crudPesquisaModel;
	}

	public void setCrudPesquisaModel(T crudPesquisaModel) {
		this.crudPesquisaModel = crudPesquisaModel;
	}
}
