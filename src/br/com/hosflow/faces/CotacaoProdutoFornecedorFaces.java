package br.com.hosflow.faces;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.hosflow.business.CotacaoProdutoFornecedorBS;
import br.com.hosflow.business.CrudBS;
import br.com.hosflow.business.FornecedorBS;
import br.com.hosflow.model.CotacaoModel;
import br.com.hosflow.model.CotacaoProdutoFornecedorModel;
import br.com.hosflow.model.CotacaoProdutoModel;
import br.com.hosflow.model.FornecedorModel;
import br.com.hosflow.util.Utilitario;
import br.com.topsys.util.TSUtil;
import br.com.topsys.web.util.TSFacesUtil;

@ManagedBean(name = "cotacaoProdutoFornecedorFaces")
public class CotacaoProdutoFornecedorFaces extends CrudFaces<CotacaoProdutoFornecedorModel> {

	@EJB
	private CotacaoProdutoFornecedorBS cotacaoProdutoFornecedorBS;

	@EJB
	private FornecedorBS fornecedorBS;

	@PostConstruct
	private void init() {

		this.clearFields();

	}

	@Override
	protected void clearFields() {

		this.crudModel = new CotacaoProdutoFornecedorModel();
		this.crudModel.setCotacaoProdutoModel(new CotacaoProdutoModel());
		this.crudModel.setFornecedorModel(new FornecedorModel());

		this.grid = new ArrayList<CotacaoProdutoFornecedorModel>();

		Long fid = new Long(TSFacesUtil.getRequestParameter("fid"));
		if (!TSUtil.isEmpty(Utilitario.tratarLong(fid))) {
			this.crudModel.setFornecedorModel(fornecedorBS.obter(new FornecedorModel(fid)));
		}

		Long cid = new Long(TSFacesUtil.getRequestParameter("ctid"));
		if (!TSUtil.isEmpty(Utilitario.tratarLong(cid))) {
			this.crudModel.setCotacaoProdutoModel(new CotacaoProdutoModel(new CotacaoModel(cid)));
		}

		if (!TSUtil.isEmpty(this.crudModel.getFornecedorModel()) && !TSUtil.isEmpty(this.crudModel.getFornecedorModel().getSenha())) {
			if (this.crudModel.getFornecedorModel().getSenha().equals(TSFacesUtil.getRequestParameter("controle"))) {
				find();
			} else {

				TSFacesUtil.getRequest().getRequestDispatcher("/pages/500.html");

			}
		} else {

			TSFacesUtil.getRequest().getRequestDispatcher("/pages/500.html");

		}

	}

	@Override
	protected String find() {

		this.grid = this.cotacaoProdutoFornecedorBS.pesquisarPorFornecedor(this.crudModel);

		return SUCESSO;

	}

	public String atualizarCotacaoFornecedor() {

		try {
			super.setDefaultMessage(false);

			super.setClearFields(false);

			for (CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel : this.grid) {

				this.cotacaoProdutoFornecedorBS.alterar(cotacaoProdutoFornecedorModel);

			}

			TSFacesUtil.addInfoMessage("Cotação enviada.");

		} catch (Exception e) {

			TSFacesUtil.addInfoMessage("Falha no envio das cotações " + e.getMessage());

			e.printStackTrace();
		}

		return SUCESSO;

	}

	@Override
	protected CrudBS getCrudBS() {
		return null;
	}

}
