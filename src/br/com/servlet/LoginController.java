package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends SegurancaController {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(!isLogado(request)) {
			request.getRequestDispatcher("WEB-INF/paginas/login.jsp").forward(request, response);
		}else {
			response.sendRedirect("/area");
		}
		
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");		
		req.login(username, password);
		req.getSession().setAttribute("USER_LOGADO", true);
		req.getSession().setAttribute("IS_ADMIN", req.isUserInRole("ADMIN"));
		resp.sendRedirect("/area");
	}
	
	
}
