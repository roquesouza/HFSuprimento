package br.com.hfsuprimento.dao;

import br.com.hfsuprimento.model.FornecedorModel;
import br.com.topsys.database.TSDataBaseBrokerIf;
import br.com.topsys.database.factory.TSDataBaseBrokerFactory;

public class FornecedorDAO {
	
	public FornecedorModel obter(final FornecedorModel model) {

        TSDataBaseBrokerIf broker = TSDataBaseBrokerFactory.getDataBaseBrokerIf();

        broker.setPropertySQL("fornecedordao.obter", model.getId());

        return (FornecedorModel) broker.getObjectBean(FornecedorModel.class, "id","tipoIdentificadorModel.id", "tipoIdentificadorModel.descricao", "identificador"
        																		,"razaoSocial","nomeFantasia","inscricaoEstadual","inscricaoMunicipal","email","homePage",
        																		"dataCadastro", "observacao","login","senha");
        																		
    }
	

}
