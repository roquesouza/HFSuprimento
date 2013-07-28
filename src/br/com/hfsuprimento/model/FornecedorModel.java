package br.com.hfsuprimento.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.topsys.util.TSUtil;

@SuppressWarnings("serial")
public class FornecedorModel extends BaseModel {
	
	private TipoIdentificadorModel tipoIdentificadorModel;
	private String identificador;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String email;
	private String homePage;
	private String login;
	private String senha;
	private BigDecimal porcentagemIR;
	private BigDecimal porcentagemISS;
	private BigDecimal porcentagemINSS;
	private String observacao;
	private List<CategoriaModel> categorias;

	
	public FornecedorModel() {
	}
	
	public FornecedorModel(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	
	public FornecedorModel(Long id) {
		this.id= id;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public BigDecimal getPorcentagemIR() {
		return porcentagemIR;
	}
	public void setPorcentagemIR(BigDecimal porcentagemIR) {
		this.porcentagemIR = porcentagemIR;
	}
	public BigDecimal getPorcentagemISS() {
		return porcentagemISS;
	}
	public void setPorcentagemISS(BigDecimal porcentagemISS) {
		this.porcentagemISS = porcentagemISS;
	}
	public BigDecimal getPorcentagemINSS() {
		return porcentagemINSS;
	}
	public void setPorcentagemINSS(BigDecimal porcentagemINSS) {
		this.porcentagemINSS = porcentagemINSS;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeFantasiaPesquisa() {
		if(TSUtil.isEmpty(this.nomeFantasia)) {
			return null;
		}
		return "%" + this.nomeFantasia + "%";
	}
	
	public List<CategoriaModel> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}

    public String getFornecedorDetalhado() {
    	
    	if (!TSUtil.isEmpty(this.getId()) && !TSUtil.isEmpty(this.nomeFantasia)) {
    	
    		return this.getId() + ": " + this.nomeFantasia;
        
    	}
        
        else {return "";}
    }
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorModel other = (FornecedorModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public TipoIdentificadorModel getTipoIdentificadorModel() {
		return tipoIdentificadorModel;
	}

	public void setTipoIdentificadorModel(TipoIdentificadorModel tipoIdentificadorModel) {
		this.tipoIdentificadorModel = tipoIdentificadorModel;
	}
	
	

}
