package br.com.hosflow.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.hosflow.dao.FornecedorDAO;
import br.com.hosflow.model.FornecedorModel;

@Stateless
@LocalBean
public class FornecedorBS {
	
	@Inject
	private FornecedorDAO fornecedorDAO;
	
	public FornecedorModel obter(final FornecedorModel model) {
		return this.fornecedorDAO.obter(model);
    }
    
    
}
