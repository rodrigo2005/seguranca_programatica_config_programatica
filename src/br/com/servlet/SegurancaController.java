package br.com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class SegurancaController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Boolean isLogado(HttpServletRequest req ) {
		return (Boolean) (req.getSession().getAttribute("USER_LOGADO") != null ? req.getSession().getAttribute("USER_LOGADO") : false); 
	}
	
}
