package br.com.hfsuprimento.faces;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hfsuprimento.dao.CotacaoProdutoFornecedorDAO;
import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.web.faces.TSMainFaces;
import br.com.topsys.web.util.TSFacesUtil;

@ViewScoped
@SuppressWarnings("serial")
@ManagedBean(name = "cotacaoProdutoFornecedorFaces")
public class CotacaoProdutoFornecedorFaces extends TSMainFaces {

	private CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel;

	@Override
	@PostConstruct
	protected void clearFields() {

		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		this.cotacaoProdutoFornecedorModel = new CotacaoProdutoFornecedorDAO().obter(TSFacesUtil.getRequestParameter("fid"));

	}

	@Override
	protected String update() throws TSApplicationException {

		CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO = new CotacaoProdutoFornecedorDAO();

		for (CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel : this.cotacaoProdutoFornecedorModel.getGrid()) {

			cotacaoProdutoFornecedorModel.setDataAtualizacao(new Date());
			cotacaoProdutoFornecedorDAO.alterar(cotacaoProdutoFornecedorModel);

		}

		return null;
	}

	public CotacaoProdutoFornecedorModel getCotacaoProdutoFornecedorModel() {
		return cotacaoProdutoFornecedorModel;
	}

	public void setCotacaoProdutoFornecedorModel(CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel) {
		this.cotacaoProdutoFornecedorModel = cotacaoProdutoFornecedorModel;
	}

}
