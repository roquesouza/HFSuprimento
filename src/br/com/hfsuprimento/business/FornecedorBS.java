package br.com.hfsuprimento.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.hfsuprimento.dao.FornecedorDAO;
import br.com.hfsuprimento.model.FornecedorModel;

@Stateless
@LocalBean
public class FornecedorBS {
	
	@Inject
	private FornecedorDAO fornecedorDAO;
	
	public FornecedorModel obter(final FornecedorModel model) {
		return this.fornecedorDAO.obter(model);
    }
    
    
}
