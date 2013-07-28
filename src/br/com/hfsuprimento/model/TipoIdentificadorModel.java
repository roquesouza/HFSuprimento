/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hfsuprimento.model;

import java.io.Serializable;

import br.com.hfsuprimento.util.Utilitario;
import br.com.topsys.util.TSUtil;

/**
 *
 * @author roque souza
 */
@SuppressWarnings("serial")
public class TipoIdentificadorModel implements Serializable {

  private Long id;
  private String descricao;
  private String mascara;
  
  public Boolean isIdNulo() {
	  return TSUtil.isEmpty(Utilitario.tratarLong(this.id));
  }

  public TipoIdentificadorModel(Long id) {
    this.id = id;
  }
  
  public TipoIdentificadorModel() {
    
  }
  
  public Long getId() {   
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getMascara() {
    return mascara;
  }

  public void setMascara(String mascara) {
    this.mascara = mascara;
  }

}
