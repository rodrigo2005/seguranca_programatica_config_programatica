package br.com.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/area" })
public class Filtro extends SegurancaFiltro  implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("chamando filtro . . .");
		HttpServletRequest req = (HttpServletRequest) request;

		if(isLogado(req)){
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/paginas/login.jsp").forward(request, response);
		}	
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
