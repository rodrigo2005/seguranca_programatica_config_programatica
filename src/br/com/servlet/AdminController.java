package br.com.servlet;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class area
 */
@WebServlet("/admin")
@ServletSecurity(
		
@HttpConstraint(transportGuarantee = TransportGuarantee.NONE,rolesAllowed = {"ADMIN"}))

@DeclareRoles({"ADMIN"})

public class AdminController extends SegurancaController {
	private static final long serialVersionUID = 1L;
   
	private static Logger logger = Logger.getLogger(AreaController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
	
		try {
	    request.getRequestDispatcher("WEB-INF/paginas/seguras/admin/restrita.jsp").forward(request, response);
		}catch (EJBAccessException ejb) {
			logger.info("Este metodo só e possível ser acessado por administradores");
		}
	}

}
