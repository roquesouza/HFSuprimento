package br.com.hfsuprimento.faces;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hfsuprimento.dao.CotacaoProdutoFornecedorDAO;
import br.com.hfsuprimento.model.CotacaoFornecedorModel;
import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.exception.TSSystemException;
import br.com.topsys.web.faces.TSMainFaces;
import br.com.topsys.web.util.TSFacesUtil;

@ViewScoped
@SuppressWarnings("serial")
@ManagedBean(name = "cotacaoProdutoFornecedorFaces")
public class CotacaoProdutoFornecedorFaces extends TSMainFaces {

	private CotacaoFornecedorModel cotacaoFornecedorModel;
	
	private CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO;

	private String fid;

	private static final String SUCCESS = "sucess";
	private static final String ERROR = "error";

	@Override
	@PostConstruct
	protected void clearFields() {
		
		this.cotacaoProdutoFornecedorDAO = new CotacaoProdutoFornecedorDAO();

		FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		this.fid = TSFacesUtil.getRequestParameter("fid");

		String success = (String) TSFacesUtil.getObjectInSession(SUCCESS);
		String error = (String) TSFacesUtil.getObjectInSession(ERROR);

		if (success != null) {
			super.addInfoMessage(success);
			TSFacesUtil.removeObjectInSession(SUCCESS);
		}
		
		if (error != null) {
			super.addErrorMessage(error);
			TSFacesUtil.removeObjectInSession(ERROR);
		}

		this.obterCotacao();
	}

	public String obterCotacao() {
		this.cotacaoFornecedorModel = this.cotacaoProdutoFornecedorDAO.obter(this.fid);
		return null;
	}

	public String salvarIndividual(CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel) {
		
		try {

			cotacaoProdutoFornecedorModel.setDataAtualizacao(new Date());
			
			this.cotacaoProdutoFornecedorDAO.alterar(cotacaoProdutoFornecedorModel);

			super.addInfoMessage("Operação realizada com sucesso");

		} catch (TSApplicationException e) {
			
			super.throwException(e);
			
		} catch (TSSystemException e){
			
			super.addErrorMessage("Ocorreu um erro ao salvar a cotação");
			e.printStackTrace();
			
		}

		return null;
		
	}
	
	public String salvar() {

		this.cotacaoFornecedorModel.setDataAtualizacao(new Date());
		
		try {
			
			this.cotacaoProdutoFornecedorDAO.alterar(this.cotacaoFornecedorModel);

			for (CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel : this.cotacaoFornecedorModel.getGrid()) {

				cotacaoProdutoFornecedorModel.setDataAtualizacao(new Date());
				
				this.cotacaoProdutoFornecedorDAO.alterar(cotacaoProdutoFornecedorModel);

			}
			
			super.addInfoMessage("Operação realizada com sucesso");
			//TSFacesUtil.addObjectInSession(SUCCESS, "Operação realizada com sucesso");

		} catch (TSApplicationException e) {
			
			super.throwException(e);
			
		} catch (TSSystemException e){
			
			super.addInfoMessage("Ocorreu um erro ao salvar a cotação");
			//TSFacesUtil.addObjectInSession(ERROR, "Ocorreu um erro ao salvar a cotação");
			e.printStackTrace();
			
		}

		//return "/pages/cotacao.xhtml?faces-redirect=true&fid=" + this.fid;
		return null;
	}

	public CotacaoFornecedorModel getCotacaoFornecedorModel() {
		return cotacaoFornecedorModel;
	}

	public void setCotacaoFornecedorModel(CotacaoFornecedorModel cotacaoFornecedorModel) {
		this.cotacaoFornecedorModel = cotacaoFornecedorModel;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

}
