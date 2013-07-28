/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hfsuprimento.dao;

import java.util.List;

import br.com.topsys.exception.TSApplicationException;

/**
 *
 * @author roquesouza
 */
public interface CrudDAO<T> {
  
	public T obter(final T model);
	public List<T> pesquisar(final T model);  
	public T inserir(final T model) throws TSApplicationException ;
	public T alterar(final T model) throws TSApplicationException ;
	public T excluir(final T model) throws TSApplicationException ;
  
}
