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

	@Override
	@PostConstruct
	protected void clearFields() {

		FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		this.cotacaoProdutoFornecedorModel = new CotacaoProdutoFornecedorDAO().obter(TSFacesUtil.getRequestParameter("fid"));

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
