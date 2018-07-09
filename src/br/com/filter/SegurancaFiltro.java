package br.com.filter;

import javax.servlet.http.HttpServletRequest;

public abstract class SegurancaFiltro {
	
	protected Boolean isLogado(HttpServletRequest req ) {
		return (Boolean) (req.getSession().getAttribute("USER_LOGADO") != null ? req.getSession().getAttribute("USER_LOGADO") : false); 
	}
	
}
