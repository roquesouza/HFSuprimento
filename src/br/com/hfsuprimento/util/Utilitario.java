package br.com.hfsuprimento.util;import java.io.Serializable;import br.com.topsys.util.TSUtil;@SuppressWarnings("serial")public class Utilitario implements Serializable {	public static Double tratarDouble(Double valor) {		if (!TSUtil.isEmpty(valor) && valor.equals(0D)) {			valor = null;		}		return valor;	}}