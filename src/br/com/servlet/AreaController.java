package br.com.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.beans.AreaInt;

/**
 * Servlet implementation class area
 */
@WebServlet("/area")
@ServletSecurity(
/*@HttpConstraint(transportGuarantee = TransportGuarantee.NONE,
    rolesAllowed = {"ADMIN","USER"}))
@DeclareRoles({"ADMIN","USER"})*/

		httpMethodConstraints = {
				  @HttpMethodConstraint(value = "GET", rolesAllowed = {"ADMIN","USER"}),
				  @HttpMethodConstraint(value = "POST", rolesAllowed = "ADMIN",
				                        transportGuarantee = TransportGuarantee.NONE),      
				 })
		
public class AreaController extends SegurancaController {
	private static final long serialVersionUID = 1L;
   
	private static Logger logger = Logger.getLogger(AreaController.class);
	
	@EJB
	private AreaInt area;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
	
		try {
		String login = area.getLogin();
		response.getWriter().append("Login: ").append(login);
	    request.getRequestDispatcher("WEB-INF/paginas/seguras/restrita.jsp").forward(request, response);
		}catch (EJBAccessException ejb) {
			logger.info("Este metodo só e possível ser acessado por administradores");
		}
	}

}
