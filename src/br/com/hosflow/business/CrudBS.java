package br.com.hosflow.business;

import java.io.Serializable;
import java.util.List;

import br.com.hosflow.dao.CrudDAO;
import br.com.topsys.exception.TSApplicationException;

public abstract class CrudBS<T extends Serializable> {

	public CrudBS() {

	}

	protected abstract CrudDAO<T> getCrudDAO();

	public List<T> pesquisar(final T crudModel) {
		return getCrudDAO().pesquisar(crudModel);
	}

	public T obter(final T crudModel) {
		return getCrudDAO().obter(crudModel);
	}

	public T inserir(final T crudModel) throws TSApplicationException {
		return getCrudDAO().inserir(crudModel);
	}

	public T alterar(final T crudModel) throws TSApplicationException {
		return getCrudDAO().alterar(crudModel);
	}

	public T excluir(final T crudModel) throws TSApplicationException {
		return getCrudDAO().excluir(crudModel);
	}

}
