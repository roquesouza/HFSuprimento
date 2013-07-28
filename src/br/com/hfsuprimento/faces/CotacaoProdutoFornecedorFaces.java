package br.com.hfsuprimento.faces;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.hfsuprimento.business.CotacaoProdutoFornecedorBS;
import br.com.hfsuprimento.business.CrudBS;
import br.com.hfsuprimento.business.FornecedorBS;
import br.com.hfsuprimento.model.CotacaoModel;
import br.com.hfsuprimento.model.CotacaoProdutoFornecedorModel;
import br.com.hfsuprimento.model.CotacaoProdutoModel;
import br.com.hfsuprimento.model.FornecedorModel;
import br.com.hfsuprimento.util.Utilitario;
import br.com.topsys.constant.TSConstant;
import br.com.topsys.exception.TSSystemException;
import br.com.topsys.util.TSCryptoUtil;
import br.com.topsys.util.TSUtil;
import br.com.topsys.web.util.TSFacesUtil;

@ManagedBean(name = "cotacaoProdutoFornecedorFaces")
@ViewScoped
public class CotacaoProdutoFornecedorFaces extends CrudFaces<CotacaoProdutoFornecedorModel> {

	@EJB
	private CotacaoProdutoFornecedorBS cotacaoProdutoFornecedorBS;

	@EJB
	private FornecedorBS fornecedorBS;
	
	private String paramControle;
	private Long fid;
	private Long cid;
	
	public CotacaoProdutoFornecedorFaces() {
		paramControle = TSFacesUtil.getRequestParameter("controle");
		cid = new Long(TSFacesUtil.getRequestParameter("ctid"));
		fid = new Long(TSFacesUtil.getRequestParameter("fid"));
	}

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
		
		if (!TSUtil.isEmpty(Utilitario.tratarLong(fid))) {
			this.crudModel.setFornecedorModel(fornecedorBS.obter(new FornecedorModel(fid)));
		}

		
		if (!TSUtil.isEmpty(Utilitario.tratarLong(cid))) {
			this.crudModel.setCotacaoProdutoModel(new CotacaoProdutoModel(new CotacaoModel(cid)));
		}

		try {

			if (!TSUtil.isEmpty(this.crudModel.getFornecedorModel())) {
				
				String controle = TSCryptoUtil.gerarHash(this.crudModel.getCotacaoProdutoModel().getCotacaoModel().getId().toString() + this.crudModel.getFornecedorModel().getId().toString(), TSConstant.CRIPTOGRAFIA_MD5);

				if (controle.equals(paramControle)) {

					find();

				} else {

					throw new Exception("Parametro invalido - " + this.paramControle);

				}
			} else {

				throw new Exception("Fornecedor invalido " + this.cid);

			}

		} catch (Exception ex) {
			throw new TSSystemException(ex);
		}

	}

	@Override
	protected String find() {

		this.grid = this.cotacaoProdutoFornecedorBS.pesquisarPorFornecedor(this.crudModel);

		return null;

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

		return null;

	}

	@Override
	protected CrudBS getCrudBS() {
		return null;
	}

}
