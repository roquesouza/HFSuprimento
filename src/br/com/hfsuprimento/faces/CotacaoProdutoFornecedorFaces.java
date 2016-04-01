package br.com.hfsuprimento.faces;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

	private String fid;

	private static final String SUCCESS = "sucess";

	@Override
	@PostConstruct
	protected void clearFields() {

		FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		this.fid = TSFacesUtil.getRequestParameter("fid");

		String success = (String) TSFacesUtil.getObjectInSession(SUCCESS);

		if (success != null) {
			super.addInfoMessage("Operação realizada com sucesso");
			TSFacesUtil.removeObjectInSession(SUCCESS);
		}

		this.obterCotacao();
	}

	public String obterCotacao() {
		this.cotacaoProdutoFornecedorModel = new CotacaoProdutoFornecedorDAO().obter(this.fid);
		return null;
	}

	public String calcularValorUnitario(CotacaoProdutoFornecedorModel model) {

		BigDecimal valorTotal = new BigDecimal(model.getValorTotal());
		BigDecimal quantidade = new BigDecimal(model.getCotacaoProdutoModel().getQuantidadeSolicitada());

		model.setValor(valorTotal.divide(quantidade, 10, RoundingMode.HALF_UP).doubleValue());

		return null;
	}

	public String calcularValorTotal(CotacaoProdutoFornecedorModel model) {

		BigDecimal valorUnitario = new BigDecimal(model.getValor());
		BigDecimal quantidade = new BigDecimal(model.getCotacaoProdutoModel().getQuantidadeSolicitada());

		model.setValorTotal(valorUnitario.multiply(quantidade).doubleValue());

		return null;
	}

	public String salvar() {

		CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO = new CotacaoProdutoFornecedorDAO();

		try {

			for (CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel : this.cotacaoProdutoFornecedorModel.getGrid()) {

				cotacaoProdutoFornecedorModel.setDataAtualizacao(new Date());
				cotacaoProdutoFornecedorDAO.alterar(cotacaoProdutoFornecedorModel);

			}

		} catch (TSApplicationException e) {
			super.throwException(e);
		}

		TSFacesUtil.addObjectInSession(SUCCESS, "ok");

		return "/pages/cotacao.xhtml?faces-redirect=true&fid=" + this.fid;
	}

	public CotacaoProdutoFornecedorModel getCotacaoProdutoFornecedorModel() {
		return cotacaoProdutoFornecedorModel;
	}

	public void setCotacaoProdutoFornecedorModel(CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel) {
		this.cotacaoProdutoFornecedorModel = cotacaoProdutoFornecedorModel;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

}
