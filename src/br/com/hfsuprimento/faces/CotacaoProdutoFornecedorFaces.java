package br.com.hfsuprimento.faces;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.hfsuprimento.dao.CotacaoProdutoFornecedorDAO;
import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.topsys.exception.TSApplicationException;
import br.com.topsys.util.TSUtil;
import br.com.topsys.web.faces.TSMainFaces;
import br.com.topsys.web.util.TSFacesUtil;

@ViewScoped
@ManagedBean(name = "cotacaoProdutoFornecedorFaces")
public class CotacaoProdutoFornecedorFaces extends TSMainFaces {

	private CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel;
	private List<CotacaoProdutoFornecedorModel> grid;

	@Override
	@PostConstruct
	protected void clearFields() {

		CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO = new CotacaoProdutoFornecedorDAO();

		this.cotacaoProdutoFornecedorModel = cotacaoProdutoFornecedorDAO.obter(TSFacesUtil.getRequestParameter("fid"));

		if (!TSUtil.isEmpty(cotacaoProdutoFornecedorModel)) {

			this.grid = cotacaoProdutoFornecedorDAO.pesquisar(this.cotacaoProdutoFornecedorModel);

			for (CotacaoProdutoFornecedorModel fornecedor : this.grid) {

				fornecedor.getCotacaoProdutoModel().getProdutoModel().setFabricantesAutorizados(cotacaoProdutoFornecedorDAO.pesquisarFabricantesAutorizados(fornecedor));

			}

		}

	}

	@Override
	protected String update() throws TSApplicationException {

		CotacaoProdutoFornecedorDAO cotacaoProdutoFornecedorDAO = new CotacaoProdutoFornecedorDAO();

		for (CotacaoProdutoFornecedorModel cotacaoProdutoFornecedorModel : this.grid) {

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

	public List<CotacaoProdutoFornecedorModel> getGrid() {
		return grid;
	}

	public void setGrid(List<CotacaoProdutoFornecedorModel> grid) {
		this.grid = grid;
	}

}
